package template_method.impostos;

import java.math.BigDecimal;

import domain.Imposto;
import domain.Orcamento;

public abstract class TemplateDeImpostoCondicional implements Imposto{

	@Override
	public final BigDecimal calcula(Orcamento orcamento) {
		if(deveUsarMaximaTaxacao(orcamento)) return maximaTaxacao(orcamento);
		
		return minimaTaxacao(orcamento);
	}

	protected abstract boolean deveUsarMaximaTaxacao(Orcamento orcamento);
	
	protected abstract BigDecimal maximaTaxacao(Orcamento orcamento);
	
	protected abstract BigDecimal minimaTaxacao(Orcamento orcamento);

}
