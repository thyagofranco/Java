package chain_of_responsability.requisicao;

import domain.Conta;

public class SemFormato implements Resposta {

	@Override
	public String responde(Requisicao req, Conta conta) {

		return "Formato não suportado";
	}

}
