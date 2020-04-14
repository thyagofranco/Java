package chain_of_responsability.desconto;
import java.math.BigDecimal;

import domain.Orcamento;

public class CalculadorDeDesconto {

	public BigDecimal calcula(Orcamento orcamento) {
				
		Desconto d1 = new DescontoPorCincoItens();
		Desconto d2 = new DescontoPorMaisDeQuinhentosReais(); 
		Desconto d3 = new DescontoPorVendaCasada();
		Desconto d4 = new SemDesconto();
		
		d1.setProximo(d2);
		d2.setProximo(d3);
		d3.setProximo(d4);
		
		return d1.desconta(orcamento);
	}
}
