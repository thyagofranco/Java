package chain_of_responsability.requisicao;

import domain.Conta;
import domain.Formato;

public class XML implements Resposta {

	private Resposta proximo;
	
	public XML() {}
	
	public XML(Resposta proximaResposta) {
		this.proximo = proximaResposta;
	}

	@Override
	public String responde(Requisicao req, Conta conta) {
		
		
		if(req.getFormato() == Formato.XML) { 
			
			return "<conta><titular>"
						+ conta.getNomeTitular()
						+"</titular><saldo>"
						+ conta.getSaldo()
						+"</saldo></conta>";
		
		}
		
		return (proximo != null) ? proximo.responde(req, conta) : "Formato não suportado";
	}


}
