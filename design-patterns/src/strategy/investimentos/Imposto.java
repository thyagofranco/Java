package strategy.investimentos;

import java.math.BigDecimal;

public class Imposto {

	public BigDecimal cobrarImposto(BigDecimal lucroInvestimento) {
		return lucroInvestimento.multiply(new BigDecimal(0.75));
	}
}
