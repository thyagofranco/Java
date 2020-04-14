package template_method.relatorios;

import java.util.Calendar;
import java.util.List;

import domain.Conta;

public class RelatorioComplexo extends RelatorioTemplate{

	@Override
	protected void cabecalho() {
		System.out.println("Banco XYZ");
		System.out.println("Avenida Paulista, 1234");
		System.out.println("(11) 1234-5678");
	}

	@Override
	protected void rodape() {
		System.out.println("banco@xyz.com.br");
		System.out.println(Calendar.getInstance().getTime());
		
	}

	@Override
	protected void corpo(List<Conta> contas) {
		contas.stream().forEach(c -> System.out.println( c.getNomeTitular() + " - " + c.getNumero() + " - " + c.getAgencia() + " - " + c.getSaldo() ));
		
	}

}
