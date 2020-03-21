package strategy.investimentos;

import java.math.BigDecimal;

public interface Investimento {
	
	public BigDecimal investir(Conta conta);
}
