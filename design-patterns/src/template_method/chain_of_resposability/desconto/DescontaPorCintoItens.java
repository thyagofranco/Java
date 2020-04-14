package template_method.chain_of_resposability.desconto;

import java.math.BigDecimal;

import domain.Orcamento;

public class DescontaPorCintoItens extends DescontoTemplate{
	
	public DescontaPorCintoItens() {}

	public DescontaPorCintoItens(DescontoTemplate proximoTemplate) {
		super(proximoTemplate);
		
	}

	@Override
	protected BigDecimal desconta(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal(0.10));
	}

	@Override
	protected boolean deveAplicarDesconto(Orcamento orcamento) {
		return orcamento.getItens().size() > 5 ? true : false;
	}

}
