package br.com.caelum.leilao.servico;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {
	private Double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private Double menorDeTodos = Double.POSITIVE_INFINITY;
	private Double somaDosLances = 0.0;
	private Integer quantidadeLances = 0;
	private List<Lance> maiores;
	
	public void avalia(Leilao leilao) {
		
		if(leilao.getLances().size() == 0) throw new RuntimeException("Não é possível avaliar um leilão sem lances.");
		
		leilao.getLances().forEach(lance -> {
			somaDosLances += lance.getValor();
			quantidadeLances++;
			if(lance.getValor() > maiorDeTodos) maiorDeTodos = lance.getValor();
			if(lance.getValor() < menorDeTodos ) menorDeTodos = lance.getValor();
			
			});
		
		maiores = new ArrayList<Lance>(leilao.getLances());
		Collections.sort(maiores, new Comparator<Lance>() {

			@Override
			public int compare(Lance o1, Lance o2) {
				if(o1.getValor() < o2.getValor()) return 1;
				if(o1.getValor() > o2.getValor()) return -1;
				return 0;
			}
			
		});
		
		maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size() );
		
		
		
	}
	
	public Double getMaiorLance() {
		return maiorDeTodos;
	}
	
	public Double getMenorLance() {
		return menorDeTodos;
	}
	
	public Double getMediaLances() {
		return somaDosLances / quantidadeLances;
	}
	
	public List<Lance> getTresMaioresLances() {
		return maiores;
	}
}
