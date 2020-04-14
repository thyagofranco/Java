package state.orcamento;

import domain.Orcamento;

public interface EstadoDeUmOrcamento {
	void aplicaDescontoExtra(Orcamento orcamento);
	void aprova(Orcamento orcamento);
	void reprova(Orcamento orcamento);
	void finalizar(Orcamento orcamento);
}
