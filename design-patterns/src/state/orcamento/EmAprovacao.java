package state.orcamento;

import java.math.BigDecimal;

import domain.Orcamento;

public class EmAprovacao implements EstadoDeUmOrcamento{
	
	private boolean descontoFoiAplicado = false;

	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		if(!descontoFoiAplicado) {
			orcamento.setValor(orcamento.getValor().multiply(new BigDecimal(0.95)));
			this.descontoFoiAplicado = true;
		}
		else if (descontoFoiAplicado) {
			throw new ErroDescontoDuplicado();
		}
		
				
	}

	@Override
	public void aprova(Orcamento orcamento) {
		orcamento.setEstadoAtual(new Aprovado());
	}

	@Override
	public void reprova(Orcamento orcamento) {
		orcamento.setEstadoAtual(new Reprovado());		
	}

	@Override
	public void finalizar(Orcamento orcamento) {
		throw new ErroEstadoObjeto();
		
	}


}
