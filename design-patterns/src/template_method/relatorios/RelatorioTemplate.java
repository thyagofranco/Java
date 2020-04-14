package template_method.relatorios;

import java.util.List;

import domain.Conta;

abstract class RelatorioTemplate {

	protected abstract void cabecalho();
	protected abstract void rodape();
	protected abstract void corpo(List<Conta> contas);
	
	public void imprime(List<Conta> contas) {
		cabecalho();
		corpo(contas);
		rodape();
	}
}
