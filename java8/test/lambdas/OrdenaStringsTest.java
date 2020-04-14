package lambdas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lambdas.OrdenaStrings;

public class OrdenaStringsTest {

	private OrdenaStrings ordenador;
	private List<String> palavras;
	
	@BeforeEach
	public void criaOrdenador() {
		this.ordenador = new OrdenaStrings();
		
		this.palavras = Arrays.asList("editora casa do codigo",
									  "caelum",
									  "alura online");
		
	}
	
	@Test
	public void deveOrdenarListaPorTamanho() {		
		List<String >palavrasOrdenadas = Arrays.asList("caelum",
													  "alura online",
													  "editora casa do codigo");
		
		assertEquals(palavrasOrdenadas, ordenador.ordenaPorTamanhoSemLambda(palavras));
	}
	
	
	
}
