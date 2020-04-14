package decorator.filtros_de_contas;

import java.util.ArrayList;
import java.util.List;

import domain.Conta;

public abstract class Filtro {

	private final Filtro proximoFiltro;
	
	public Filtro(Filtro outroFiltro) {
		this.proximoFiltro = outroFiltro;
	}
	
	public Filtro() {
		this.proximoFiltro = null;
	}
	
	public abstract List<Conta> filtrar(List<Conta> contas); 
	
	
	protected List<Conta> aplicarProximoFiltro(List<Conta> contas){
		return(proximoFiltro != null) ? proximoFiltro.filtrar(contas) : new ArrayList<Conta>();
	}
	
	
}
