package strategy.imposto;

import java.math.BigDecimal;

import domain.Imposto;
import domain.Orcamento;

public class ICMS implements Imposto{

	@Override
	public BigDecimal calcula(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal(0.1));
	}
}
