package state.orcamento;

public class ErroDescontoDuplicado extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErroDescontoDuplicado() {
		super("Você já aplicou desconto");
	}
}
