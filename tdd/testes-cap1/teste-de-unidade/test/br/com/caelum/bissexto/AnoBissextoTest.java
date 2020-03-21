package br.com.caelum.bissexto;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class AnoBissextoTest {
	
	@Test
	public void testaAnoMultiplo400() {
		
		assertTrue(AnoBissexto.ehBissexto(4000));
	}
	
	@Test
	public void testaAnoNaoMultiplo400() {
		
		assertFalse(AnoBissexto.ehBissexto(4001));
	}
	
	@Test
	public void testaAnoMultiplo400MultipoDe100MultiploDe4() {
	
		assertFalse(AnoBissexto.ehBissexto(4100));
	
	}
	
	@Test
	public void testaAnoMultiplo400NaoMultipoDe100MultiploDe4() {
	
		assertTrue(AnoBissexto.ehBissexto(2020));
	
	}
	
}
