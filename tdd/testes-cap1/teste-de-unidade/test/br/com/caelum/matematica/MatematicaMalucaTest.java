package br.com.caelum.matematica;

import static br.com.caelum.matematica.MatematicaMaluca.contaMaluca;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class MatematicaMalucaTest {

	@Test
	public void testaNumeroMaiorQueTrinta() {
		
		assertEquals(31*4, contaMaluca(31));
	}
	
	@Test
	public void testaNumeroMenorQueTrintaMaiorQueDez() {
		
		assertEquals(11*3, contaMaluca(11));
	}
	
	@Test
	public void testaNumeroMenorQueTrintaMenorQueDez() {
		
		assertEquals(9*2, contaMaluca(9));
	}
	
	@Test
	public void testaTrinta() {
		
			
		assertEquals(30*3, contaMaluca(30));
	}
	
	@Test
	public void testaDez() {
				
		assertEquals(10*2, contaMaluca(10));
	}
	
	
}
