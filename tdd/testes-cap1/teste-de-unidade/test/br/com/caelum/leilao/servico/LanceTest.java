package br.com.caelum.leilao.servico;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Usuario;

public class LanceTest {

	@Test
	public void valorDoLanceDeveSerMaiorQueZero() {
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Lance(new Usuario("João"), -1);
		});
	}
}
