package chain_of_responsability.desconto;
import java.math.BigDecimal;

import domain.Orcamento;

public class DescontoPorMaisDeQuinhentosReais implements Desconto {

	private Desconto proximo;

	@Override
	public BigDecimal desconta(Orcamento orcamento) {
		if((orcamento.getValor().compareTo(new BigDecimal(500.0)) == 1)) return orcamento.getValor().multiply(new BigDecimal(0.07));
		
		return proximo.desconta(orcamento);
		
		
	}

	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;

		
	}
	

}
