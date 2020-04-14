package decorator.imposto;

import java.math.BigDecimal;

import domain.Orcamento;

public class ICMS extends Imposto{

	
	public ICMS(Imposto outroImposto) {
		super(outroImposto);
	}
	
	public ICMS() {
	
	}
	
	@Override
	public BigDecimal calcula(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal(0.1)).add(calculoDoOutroImposto(orcamento));
	}

}
