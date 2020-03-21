package strategy.investimentos;

import java.math.BigDecimal;

public class Conservador implements Investimento{

	@Override
	public BigDecimal investir(Conta conta) {
		
		return conta.getSaldo().multiply(new BigDecimal(0.008));
	}
	
}
