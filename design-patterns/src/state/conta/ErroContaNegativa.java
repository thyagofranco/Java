package state.conta;

public class ErroContaNegativa extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ErroContaNegativa(String mensagem) {
		super(mensagem);
	}

}
