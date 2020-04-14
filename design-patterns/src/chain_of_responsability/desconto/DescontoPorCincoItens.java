package chain_of_responsability.desconto;
import java.math.BigDecimal;

import domain.Orcamento;

public class DescontoPorCincoItens implements Desconto{

	private Desconto proximo;

	@Override
	public BigDecimal desconta(Orcamento orcamento) {
		
		if(orcamento.getItens().size() > 5) return orcamento.getValor().multiply(new BigDecimal(0.10));
		
		return proximo.desconta(orcamento);

	}

	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
		
		
		
	}

}
