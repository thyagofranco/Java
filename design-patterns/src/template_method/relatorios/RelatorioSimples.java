package template_method.relatorios;

import java.util.List;

import domain.Conta;

public class RelatorioSimples extends RelatorioTemplate{

	@Override
	protected void cabecalho() {
		System.out.println("Banco XYZ");
		
	}

	@Override
	protected void rodape() {
		System.out.println("(11) 1234-5678");
		
	}

	@Override
	protected void corpo(List<Conta> contas) {
		contas.stream().forEach(c -> System.out.println(c.getNomeTitular() + " - " + c.getSaldo()));
		
	}

}
