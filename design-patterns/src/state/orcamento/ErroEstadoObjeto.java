package state.orcamento;

public class ErroEstadoObjeto extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5769823014119162635L;
	
	public ErroEstadoObjeto() {
		super("Erro no estado do objeto");
	}

}
