package template_method.impostos;

import java.math.BigDecimal;

import domain.Orcamento;

public class IKCV extends TemplateDeImpostoCondicional {

	@Override
	protected boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		
		return orcamento
				    .getValor()
				    .compareTo(new BigDecimal(500)) == 1 && temItemMaiorQue100ReaisNo(orcamento);
	}

	@Override
	protected BigDecimal maximaTaxacao(Orcamento orcamento) {

		return orcamento.getValor().multiply(new BigDecimal(0.10));
	}

	@Override
	protected BigDecimal minimaTaxacao(Orcamento orcamento) {
		
		return orcamento.getValor().multiply(new BigDecimal(0.06));
	}

	private boolean temItemMaiorQue100ReaisNo(Orcamento orcamento) {
		
		return orcamento.getItens()
				.stream()
				.anyMatch(item -> item.getValor().compareTo(new BigDecimal(100)) == 1);
	}
}
