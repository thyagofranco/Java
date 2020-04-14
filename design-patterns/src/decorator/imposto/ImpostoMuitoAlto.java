package decorator.imposto;

import java.math.BigDecimal;

import domain.Orcamento;

public class ImpostoMuitoAlto extends Imposto{

	
	public ImpostoMuitoAlto(Imposto outroImposto) {
		super(outroImposto);
	}
	
	public ImpostoMuitoAlto() {
		super();
	}
	
	@Override
	public BigDecimal calcula(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal(0.20)).add(calculoDoOutroImposto(orcamento));
	}

}
