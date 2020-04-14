package template_method.chain_of_resposability.desconto;

import java.math.BigDecimal;

import domain.Orcamento;

public class CalculadorDeDesconto {

	public BigDecimal calcula(Orcamento orcamento) {
		
		DescontoTemplate r2 = new DescontoPorMaisDeQuinhentosReais();
		DescontoTemplate r1 = new DescontaPorCintoItens(r2);
		
		
		return r1.avalia(orcamento);
		
	}
}
