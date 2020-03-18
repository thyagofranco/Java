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
		leilao.propoe(new Lance(MARIA, 2000));
		leilao.propoe(new Lance(JOAO, 3000));
		
		assertEquals(3, leilao.getLances().size());
		assertEquals(100.00, leilao.getLances().get(0).getValor(), 0.00001);
		assertEquals(2000.00, leilao.getLances().get(1).getValor(), 0.00001);
		assertEquals(3000.00, leilao.getLances().get(2).getValor(), 0.00001);
	}
	
	@Test 
	public void naoDeveAceitarDoisLanesSeguidosDoMesmoUsuario() {
		
		Leilao leilao = new Leilao("PS5 lançamento");
		leilao.propoe(new Lance(JOAO, 1000));
		leilao.propoe(new Lance(JOAO, 2000));
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(1000.0, leilao.getLances().get(0).getValor(), 0.00001);
	}
	
	@Test 
	public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
		
		Leilao leilao = new Leilao("PS5 lançamento");
		leilao.propoe(new Lance(JOAO, 1000));
		leilao.propoe(new Lance(MARIA, 2000));
		
		leilao.propoe(new Lance(JOAO, 3000));
		leilao.propoe(new Lance(MARIA, 4000));
		
		leilao.propoe(new Lance(JOAO, 5000));
		leilao.propoe(new Lance(MARIA, 6000));
		
		leilao.propoe(new Lance(JOAO, 7000));
		leilao.propoe(new Lance(MARIA, 8000));
		
		leilao.propoe(new Lance(JOAO, 9000));
		leilao.propoe(new Lance(MARIA, 10000));
		
		//devem ser ignorados
		leilao.propoe(new Lance(JOAO, 11000));
		leilao.propoe(new Lance(MARIA, 12000));
		
		assertEquals(10, leilao.getLances().size());
		assertEquals(10000.0, leilao.getLances().get(leilao.getLances().size() -1).getValor(), 0.00001);
	}
	
	@Test
	public void deveDobrarUltimoLanceDoUsuarioQueJaDeuUmLance() {
	
		Leilao leilao = new Leilao("PS5 lançamento");
		leilao.propoe(new Lance(JOAO, 1000));
		leilao.propoe(new Lance(MARIA, 1500));
		
		leilao.dobraLance(JOAO);
		
		assertEquals(3, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(leilao.getLances().size() -1).getValor(), 0.00001);
	}
	
	@Test
	public void deveIgnorarDobraDeLanceDoUsuarioQueNaoDeuLance() {
	
		Leilao leilao = new Leilao("PS5 lançamento");
		leilao.propoe(new Lance(MARIA, 2000));
		
		leilao.dobraLance(JOAO);
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(leilao.getLances().size() -1).getValor(), 0.00001);
		assertEquals(MARIA, leilao.getLances().get(leilao.getLances().size() -1).getUsuario());
	}
	
}
