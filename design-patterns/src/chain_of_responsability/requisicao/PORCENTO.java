package chain_of_responsability.requisicao;

import domain.Conta;
import domain.Formato;

public class PORCENTO implements Resposta {

	private Resposta proximo;
	
	
	public PORCENTO() {}

	public PORCENTO(Resposta proximaResposta) {
		this.proximo = proximaResposta;
	}


	@Override
	public String responde(Requisicao req, Conta conta) {

		if(req.getFormato() == Formato.PORCENTO) {
			
			return "conta%titular%"
					+ conta.getNomeTitular()
					+ "%saldo%"
					+ conta.getSaldo();
			
		}
		
		return (proximo != null) ? proximo.responde(req, conta) : "Formato não suportado";
	}

}
