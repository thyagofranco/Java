package br.com.caelum.leilao.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LeilaoTest {
	
	private final Usuario JOAO = new Usuario("João");
	private final Usuario MARIA = new Usuario("Maria");

	@Test
	public void deveReceberUmLance() {
		
		Leilao leilao = new Leilao("PS5 lançamento");
		assertEquals(0, leilao.getLances().size());
		
		leilao.propoe(new Lance(JOAO, 100));
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(100.00, leilao.getLances().get(0).getValor(), 0.00001);
	}
	
	@Test
	public void deveReceberMultiplosLances() {
		
		Leilao leilao = new Leilao("PS5 lançamento");
		assertEquals(0, leilao.getLances().size());
		
		leilao.propoe(new Lance(JOAO, 100));
		leilao.propoe(new Lance(JOAO, 2000));
		leilao.propoe(new Lance(MARIA, 3000));
		
		assertEquals(3, leilao.getLances().size());
		assertEquals(100.00, leilao.getLances().get(0).getValor(), 0.00001);
		assertEquals(2000.00, leilao.getLances().get(1).getValor(), 0.00001);
		assertEquals(3000.00, leilao.getLances().get(2).getValor(), 0.00001);
	}
	
}
