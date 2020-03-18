package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	private Integer NUMERO_MAXIMO_LANCES = 5;
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance lance) {
		
		if(lances.isEmpty() || (!ehUsuarioDoUltimoLance(lance) && !numeroMaximoLancesAtingido(lance))) lances.add(lance);
			
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
		
	}

	public void dobraLance(Usuario usuario) {
		
		List<Lance> lancesDoUsuarioLances = lances.stream()
												  .filter(l -> l.getUsuario().equals(usuario))
												  .collect(Collectors.toList());
		
		double maiorLance = Double.NEGATIVE_INFINITY;
		
		if(!lancesDoUsuarioLances.isEmpty()) {
			maiorLance = lancesDoUsuarioLances.get(lancesDoUsuarioLances.size()-1).getValor();
			this.propoe(new Lance(usuario, maiorLance * 2));
		}
		
	}
	
	private boolean ehUsuarioDoUltimoLance(Lance lance) {
		
		return lance.getUsuario().equals(lances.get(lances.size()-1).getUsuario()) ? true : false;
		
	}

	private boolean numeroMaximoLancesAtingido(Lance lance) {
		
		return lances.stream()
				.filter(l -> l.getUsuario().equals(lance.getUsuario()))
				.count() >= NUMERO_MAXIMO_LANCES ? true : false;
		 	
	}

	
}
