package decorator.filtros_de_contas;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import domain.Conta;

public class FiltroMaiorQuinhentosMilReais extends Filtro {
	
	public FiltroMaiorQuinhentosMilReais(Filtro proximoFiltro) {
		super(proximoFiltro);
	}
	
	public FiltroMaiorQuinhentosMilReais() {
		super();
	}

	@Override
	public List<Conta> filtrar(List<Conta> contas) {
		List<Conta> filtrada = contas.stream()
				     .filter(conta -> conta.getSaldo().compareTo(new BigDecimal(500000.0)) == 1)
				     .collect(Collectors.toList());
		filtrada.addAll(aplicarProximoFiltro(contas));
		return filtrada;
	}

}
