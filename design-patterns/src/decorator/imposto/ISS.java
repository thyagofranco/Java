package decorator.imposto;

import java.math.BigDecimal;

import domain.Orcamento;


public class ISS extends Imposto {

	public ISS(Imposto outroImposto) {
		super(outroImposto);
	}
	
	public ISS() {
	}
	
	@Override
	public BigDecimal calcula(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal(0.06)).add(calculoDoOutroImposto(orcamento));
	}
	
}
