package strategy.investimentos;

import java.math.BigDecimal;

import domain.Conta;

public class RealizadorDeInvestimentos {
	
	private Imposto imposto;

	public RealizadorDeInvestimentos(Imposto imposto) {
		this.imposto = imposto;
	}

	public void investir(Conta conta, Investimento investimento) {
		
		BigDecimal resultadoInvestimento = 	investimento.investir(conta);
		
		conta.deposita(imposto.cobrarImposto(resultadoInvestimento));
		
	}

}
