package br.com.caelum.leilao.servico;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class AvaliadorTest {
        
		@Test
		public void deveEntenderleilaoComLancesEmOrdemCrescente() {
		//parte 1: criando cenário
		Usuario joao = new Usuario("João");
		Usuario maria = new Usuario("Maria");
		Usuario jose = new Usuario("Jose");
		
		Leilao leilao = new Leilao("Playstation 3 Novo");
		
		leilao.propoe(new Lance(joao, 250.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria,400.0));
		
		//parte 2: ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		//parte 3: validação
		double maiorEsperado = 400;
		double menorEsperado = 250;
		double mediaEsperada = 316.66;
		
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001); // 0.00001 Delta de arredondameto para JUnit
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
		assertEquals(mediaEsperada, leiloeiro.getMediaLances(),0.01);
		
		}
		
		@Test
		public void deveEntenderleilaoComLancesEmOrdemDecrescente() {
		//parte 1: criando cenário
		Usuario joao = new Usuario("João");
		Usuario maria = new Usuario("Maria");
		Usuario jose = new Usuario("Jose");
		
		Leilao leilao = new Leilao("Playstation 3 Novo");
		
		leilao.propoe(new Lance(joao, 3000.0));
		leilao.propoe(new Lance(jose, 2000.0));
		leilao.propoe(new Lance(maria,1000.0));
		
		//parte 2: ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		//parte 3: validação
		double maiorEsperado = 3000;
		double menorEsperado = 1000;
		double mediaEsperada = 2000.00;
		
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001); // 0.00001 Delta de arredondameto para JUnit
		assertEquals(mediaEsperada, leiloeiro.getMediaLances(),0.01);
		
		}
		
		@Test
		public void deveEntenderLeilaoComApenasUmLance() {
			Usuario joao = new Usuario("João");
			
			Leilao leilao = new Leilao("Playstation 3 Novo");
			
			leilao.propoe(new Lance(joao, 1000.0));
			
			Avaliador leiloeiro = new Avaliador();
			leiloeiro.avalia(leilao);
			
			assertEquals(1000.0, leiloeiro.getMaiorLance(), 0.00001);
			assertEquals(1000.0, leiloeiro.getMenorLance(), 0.00001);
			assertEquals(1000.0, leiloeiro.getMediaLances(), 0.01);
			
		}
		
		@Test
		public void deveEncontrarOsTresmaioresLances() {
			Usuario joao = new Usuario("João");
			Usuario maria = new Usuario("Maria");
			
			Leilao leilao = new Leilao("Playstation 3 Novo");
			
			leilao.propoe(new Lance(joao, 100.00));
			leilao.propoe(new Lance(maria, 200.00));
			leilao.propoe(new Lance(joao, 300.00));
			leilao.propoe(new Lance(maria, 400.00));
			
			Avaliador leiloeiro = new Avaliador();
			leiloeiro.avalia(leilao);
			
			List<Lance> maiores = leiloeiro.getTresMaioresLances();
			
			assertEquals(3, maiores.size());
			assertEquals(400, maiores.get(0).getValor(), 0.00001);
			assertEquals(300, maiores.get(1).getValor(), 0.00001);
			assertEquals(200, maiores.get(2).getValor(), 0.00001);
			
			
		}
	
}
