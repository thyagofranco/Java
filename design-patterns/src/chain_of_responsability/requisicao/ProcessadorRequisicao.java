package chain_of_responsability.requisicao;

import domain.Conta;

public class ProcessadorRequisicao {
	
	public String responde(Requisicao req, Conta conta) {
		Resposta r3 = new PORCENTO();
		Resposta r2 = new CVS(r3);
		Resposta r1 = new XML(r2);		
		return r1.responde(req, conta);
	}
}
