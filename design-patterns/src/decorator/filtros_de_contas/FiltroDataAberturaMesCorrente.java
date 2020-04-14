package decorator.filtros_de_contas;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import domain.Conta;

public class FiltroDataAberturaMesCorrente extends Filtro {

	public FiltroDataAberturaMesCorrente(Filtro proximFiltro) {
		super(proximFiltro);
	}
	
	public FiltroDataAberturaMesCorrente() {
		super();
	}
	
	@Override
	public List<Conta> filtrar(List<Conta> contas) {
		List<Conta> filtrada = contas.stream()
				     .filter(conta -> conta.getDataAbertura().getMonthValue() == LocalDate.now().getMonthValue())
				     .collect(Collectors.toList());
		filtrada.addAll(aplicarProximoFiltro(contas));
		return filtrada;
	}

}
