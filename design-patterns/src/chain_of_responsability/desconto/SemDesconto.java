package chain_of_responsability.desconto;
import java.math.BigDecimal;

import domain.Orcamento;

public class SemDesconto implements Desconto {

	@Override
	public BigDecimal desconta(Orcamento orcamento) {
		
		return BigDecimal.ZERO;
	}

	@Override
	public void setProximo(Desconto proximo) {
		
		
	}

}
