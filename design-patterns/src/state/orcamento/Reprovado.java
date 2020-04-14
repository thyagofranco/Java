package state.orcamento;

import domain.Orcamento;

public class Reprovado implements EstadoDeUmOrcamento {

	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		throw new ErroEstadoObjeto();		
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
