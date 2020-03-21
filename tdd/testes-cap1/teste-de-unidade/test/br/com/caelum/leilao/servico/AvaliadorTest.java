package br.com.caelum.leilao.servico;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class AvaliadorTest {
        
		private Avaliador leiloeiro;
		private Usuario jose;
		private Usuario maria;
		private Usuario joao;
		
		//parte 1: preparação
		@BeforeEach
		public void setup() {
			this.leiloeiro  = new Avaliador();			
			this.joao = new Usuario("João");
			this.maria = new Usuario("Maria");
			this.jose = new Usuario("Jose");
			
		}
		
		@AfterAll
		public static void finaliza() {
		  System.out.println("fim");
		}
		
	
		@Test
		public void deveEntenderleilaoComLancesEmOrdemCrescente() {
					
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
							 .lance(joao, 250.0)
							 .lance(jose, 300.0)
							 .lance(maria, 400.0)
							 .constroi();

		//parte 2: ação
		leiloeiro.avalia(leilao);
		
		//parte 3: validação
				
		assertEquals(400, leiloeiro.getMaiorLance(), 0.00001); // 0.00001 Delta de arredondameto para JUnit
		assertEquals(250, leiloeiro.getMenorLance(), 0.00001);
		assertEquals(316.66, leiloeiro.getMediaLances(),0.01);
		
		}

		
		@Test
		public void deveEntenderleilaoComLancesEmOrdemDecrescente() {
				
			
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
							.lance(joao, 3000.0)
							.lance(jose, 2000.0)
							.lance(maria,1000.0)
							.constroi();
		
		leiloeiro.avalia(leilao);

		double maiorEsperado = 3000;
		double menorEsperado = 1000;
		double mediaEsperada = 2000.00;
		
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001); // 0.00001 Delta de arredondameto para JUnit
		assertEquals(mediaEsperada, leiloeiro.getMediaLances(),0.01);
		
		}
		
		@Test
		public void deveEntenderLeilaoComApenasUmLance() {
					
			Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
					.lance(joao, 1000.0)
					.constroi();
			
			
			leiloeiro.avalia(leilao);
			
			assertEquals(1000.0, leiloeiro.getMaiorLance(), 0.00001);
			assertEquals(1000.0, leiloeiro.getMenorLance(), 0.00001);
			assertEquals(1000.0, leiloeiro.getMediaLances(), 0.01);
			
		}
		
		
		@Test
		public void deveEntenderUmLeilaoComLancesAleatorios() {
					
			Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
					.lance(joao, 200.0)
					.lance(maria, 450.0)
					.lance(joao,120.0)
					.lance(maria,700.0)
					.lance(joao,630.0)
					.lance(maria,230.0)
					.constroi();
			
			leiloeiro.avalia(leilao);
			
			
			assertEquals(700.00, leiloeiro.getMaiorLance(), 0.00001);
			assertEquals(120.0, leiloeiro.getMenorLance(), 0.00001);
						
		}
	
		@Test
		public void deveEncontrarOsTresmaioresLances() {
						
			Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
							.lance(joao, 100.00)
							.lance(maria, 200.00)
							.lance(joao, 300.00)
							.lance(maria, 400.00)
							.constroi();
			
			leiloeiro.avalia(leilao);
			
			List<Lance> maiores = leiloeiro.getTresMaioresLances();
			
			assertEquals(3, maiores.size());
			assertEquals(400, maiores.get(0).getValor(), 0.00001);
			assertEquals(300, maiores.get(1).getValor(), 0.00001);
			assertEquals(200, maiores.get(2).getValor(), 0.00001);
			
			
		}
		
		@Test
		public void deveEncontrarOsMaioresLancesEmUmLeilaoDeDoisLances() {
		
			Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
								.lance(joao, 100.00)
								.lance(maria, 200.00)
								.constroi();
						
			leiloeiro.avalia(leilao);
			
			List<Lance> maiores = leiloeiro.getTresMaioresLances();
			
			assertEquals(2, maiores.size());
			assertEquals(200, maiores.get(0).getValor(), 0.00001);
			assertEquals(100, maiores.get(1).getValor(), 0.00001);
						
			
		}
		
		@Test()
		public void deveEncontrarZeroLancesEmUmLeilaoSemLances() {
			assertThrows(RuntimeException.class, ()-> {
				
				Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").constroi();
				
				leiloeiro.avalia(leilao);
				
			});				
					
									
			
		}
		
		
		
}
