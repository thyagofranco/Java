package decorator.imposto;

import java.math.BigDecimal;

import domain.Orcamento;

public abstract class TemplateDeImpostoCondicional extends Imposto{
	
	public TemplateDeImpostoCondicional (Imposto outrImposto) {
		super(outrImposto);
		
	}
	
	public TemplateDeImpostoCondicional() {
		super();
	}
	
	@Override
	public final BigDecimal calcula(Orcamento orcamento) {
		if(deveUsarMaximaTaxacao(orcamento)) return maximaTaxacao(orcamento).add(calculoDoOutroImposto(orcamento));
		
		return minimaTaxacao(orcamento).add(calculoDoOutroImposto(orcamento));
	}

	protected abstract boolean deveUsarMaximaTaxacao(Orcamento orcamento);
	
	protected abstract BigDecimal maximaTaxacao(Orcamento orcamento);
	
	protected abstract BigDecimal minimaTaxacao(Orcamento orcamento);


}
