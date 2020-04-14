package chain_of_responsability.requisicao;

import domain.Conta;

public interface Resposta {
	
	String responde(Requisicao req, Conta conta);
	
}
