package chain_of_responsability.desconto;
import java.math.BigDecimal;

import domain.Orcamento;

public class DescontoPorVendaCasada implements Desconto{

	private Desconto proximo;

	@Override
	public BigDecimal desconta(Orcamento orcamento) {
				
		if(aconteceuVendaCasada(orcamento)) return orcamento.getValor().multiply(new BigDecimal(0.05));
		
		return proximo.desconta(orcamento);
	}


	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
		
	}

	private boolean aconteceuVendaCasada(Orcamento orcamento) {
		return existe("lapis", orcamento) && existe("caneta", orcamento);
	}
	
	private boolean existe(String nomeDoItem, Orcamento orcamento) {
		
		return orcamento.getItens().parallelStream().filter(item -> item.getNome().equalsIgnoreCase(nomeDoItem)).count() > 0 ? true : false;
		
	}
}
