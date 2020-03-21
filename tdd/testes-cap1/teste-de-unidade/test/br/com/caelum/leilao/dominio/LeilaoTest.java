package br.com.caelum.leilao.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.caelum.leilao.builder.CriadorDeLeilao;

public class LeilaoTest {
	
	private Usuario joao;
	private Usuario maria;

	@BeforeEach
	public void setup() {
				
		this.joao = new Usuario("João");
		this.maria = new Usuario("Maria");
		
	}
		
	
	@Test
	public void deveReceberZeroLances() {
		Leilao leilao = new CriadorDeLeilao().para("PS5 lançamento").constroi();
		
		assertEquals(0, leilao.getLances().size());
	}
	
	
	@Test
	public void deveReceberUmLance() {
		
		Leilao leilao = new CriadorDeLeilao().para("PS5 lançamento")
				.lance(joao, 100.0)
				.constroi();
		
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(100.00, leilao.getLances().get(0).getValor(), 0.00001);
	}
	
	@Test
	public void deveReceberMultiplosLances() {
		
		Leilao leilao = new CriadorDeLeilao().para("PS5 lançamento")
				.lance(joao, 100.0)
				.lance(maria, 2000.0)
				.lance(joao, 3000.0)
				.constroi();
									
		assertEquals(3, leilao.getLances().size());
		assertEquals(100.00, leilao.getLances().get(0).getValor(), 0.00001);
		assertEquals(2000.00, leilao.getLances().get(1).getValor(), 0.00001);
		assertEquals(3000.00, leilao.getLances().get(2).getValor(), 0.00001);
	}
	
	@Test 
	public void naoDeveAceitarDoisLanesSeguidosDoMesmoUsuario() {
		
		Leilao leilao = new CriadorDeLeilao().para("PS5 lançamento")
							.lance(joao, 1000.0)
							.lance(joao, 2000.0)
							.constroi();
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(1000.0, leilao.getLances().get(0).getValor(), 0.00001);
	}
	
	@Test 
	public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
		
		Leilao leilao = new CriadorDeLeilao().para("PS5 lançamento")
				.lance(joao, 1000.0)
				.lance(maria, 2000.0)
				.lance(joao, 3000.0)
				.lance(maria, 4000.0)
				.lance(joao, 5000.0)
				.lance(maria, 6000.0)
				.lance(joao, 7000.0)
				.lance(maria, 8000.0)
				.lance(joao, 9000.0)
				.lance(maria, 10000.0)
				//A partir daqui, os lances devem ser ignorados
				.lance(joao, 11000.0)
				.lance(maria, 12000.0)
				.constroi();
		
		assertEquals(10, leilao.getLances().size());
		assertEquals(10000.0, leilao.getLances().get(leilao.getLances().size() -1).getValor(), 0.00001);
	}
	
	@Test
	public void deveDobrarUltimoLanceDoUsuarioQueJaDeuUmLance() {
	
		Leilao leilao = new CriadorDeLeilao().para("PS5 lançamento")
							.lance(joao, 1000.0)
							.lance(maria, 1500.0)
							.constroi();
				
		leilao.dobraLance(joao);
		
		assertEquals(3, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(leilao.getLances().size() -1).getValor(), 0.00001);
	}
	
	@Test
	public void deveIgnorarDobraDeLanceDoUsuarioQueNaoDeuLance() {
	
		Leilao leilao = new CriadorDeLeilao().para("PS5 lançamento")
				.lance(maria, 2000.0)
				.constroi();
				
		leilao.dobraLance(joao);
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(leilao.getLances().size() -1).getValor(), 0.00001);
		assertEquals(maria, leilao.getLances().get(leilao.getLances().size() -1).getUsuario());
	}
	
}
