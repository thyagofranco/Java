package state.orcamento;

import java.math.BigDecimal;

import domain.Orcamento;

public class Aprovado implements EstadoDeUmOrcamento{
	
	private boolean descontoFoiAplicado = false;

	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		if(!descontoFoiAplicado) {
			orcamento.setValor(orcamento.getValor().multiply(new BigDecimal(0.98)));
			this.descontoFoiAplicado = true;
		}
		else if (descontoFoiAplicado) {
			throw new ErroDescontoDuplicado();
		}
	}

	@Override
	public void aprova(Orcamento orcamento) {
		throw new ErroEstadoObjeto();
		
	}

	@Override
	public void reprova(Orcamento orcamento) {
		throw new ErroEstadoObjeto();
		
	}

	@Override
	public void finalizar(Orcamento orcamento) {
		orcamento.setEstadoAtual(new Finalizado());
		
	}

}
