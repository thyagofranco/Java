package decorator.imposto;

import java.math.BigDecimal;

import domain.Orcamento;

public class ICPP extends TemplateDeImpostoCondicional{
	
	public ICPP(Imposto outroImposto) {
		super(outroImposto);
	}
	
	public ICPP() {
		super();
	}

	@Override
	protected boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor().compareTo(new BigDecimal(500)) == 1;
	}

	@Override
	protected BigDecimal maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal(0.07));
	}

	@Override
	protected BigDecimal minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal(0.05));
	}

}
