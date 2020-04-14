package template_method.chain_of_resposability.desconto;

import java.math.BigDecimal;

import domain.Orcamento;

public class DescontoPorMaisDeQuinhentosReais extends DescontoTemplate{

	public DescontoPorMaisDeQuinhentosReais() {}
	
	public DescontoPorMaisDeQuinhentosReais(DescontoTemplate proximoTemplate) {
		super(proximoTemplate);
		
	}

	@Override
	protected BigDecimal desconta(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal(0.07));
	}

	@Override
	protected boolean deveAplicarDesconto(Orcamento orcamento) {
		return orcamento.getValor().compareTo(new BigDecimal(500.0)) == 1 ? true : false;
	}

}
