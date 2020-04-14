package decorator.imposto;

import java.math.BigDecimal;

import domain.Orcamento;

public abstract class Imposto {
	
	private final Imposto outroImposto;
	
	public Imposto (Imposto outrImposto) {
		this.outroImposto = outrImposto;
		
	}
	
	public Imposto() {
		this.outroImposto = null;
	}
	
	
	public abstract BigDecimal calcula(Orcamento orcamento);
	
	protected BigDecimal calculoDoOutroImposto(Orcamento orcamento) {
		return (outroImposto != null) ? outroImposto.calcula(orcamento) : BigDecimal.ZERO ;
	}

}
