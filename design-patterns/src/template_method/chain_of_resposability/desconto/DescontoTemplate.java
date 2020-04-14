package template_method.chain_of_resposability.desconto;

import java.math.BigDecimal;

import domain.Orcamento;

abstract class DescontoTemplate {
	
	private DescontoTemplate proximoDesconto;
	
	public DescontoTemplate() {}
	
	public DescontoTemplate(DescontoTemplate proximoTemplate) {
		this.proximoDesconto = proximoTemplate;
	}
	
	public BigDecimal avalia(Orcamento orcamento) {
		if(!deveAplicarDesconto(orcamento)) return aplicaProximo(proximoDesconto, orcamento);
		
		return (proximoDesconto != null) ? desconta(orcamento) : BigDecimal.ZERO;
		
		
	}

	private BigDecimal aplicaProximo(DescontoTemplate proximoDesconto, Orcamento orcamento) {
		return proximoDesconto.avalia(orcamento);
	}

	protected abstract BigDecimal desconta(Orcamento orcamento);

	protected abstract boolean deveAplicarDesconto(Orcamento orcamento); 
}
