package br.com.caelum.leilao.servico;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Usuario;

public class FiltroDeLancesTest {
	
	private final Usuario JOAO = new Usuario("João");

	 @Test
	    public void deveSelecionarLancesEntre1000E3000() {
	        
	        FiltroDeLances filtro = new FiltroDeLances();
	        List<Lance> resultado = filtro.filtra(Arrays.asList(
	                new Lance(JOAO,2000), 
	                new Lance(JOAO,1000), 
	                new Lance(JOAO,3000), 
	                new Lance(JOAO, 800)));

	        assertEquals(1, resultado.size());
	        assertEquals(2000, resultado.get(0).getValor(), 0.00001);
	    }

	    @Test
	    public void deveSelecionarLancesEntre500E700() {
	        
	        FiltroDeLances filtro = new FiltroDeLances();
	        List<Lance> resultado = filtro.filtra(Arrays.asList(
	                new Lance(JOAO,600), 
	                new Lance(JOAO,500), 
	                new Lance(JOAO,700), 
	                new Lance(JOAO, 800)));

	        assertEquals(1, resultado.size());
	        assertEquals(600, resultado.get(0).getValor(), 0.00001);
	    }
	    
	    @Test
	    public void deveSelecionarLancesMaioresQue5000() {
	    	
	    	FiltroDeLances filtro = new FiltroDeLances();
	    	List<Lance> resultado = filtro.filtra(Arrays.asList(
	    			new Lance(JOAO, 4000),
	    			new Lance(JOAO, 5400),
	    			new Lance(JOAO, 5500),
	    			new Lance(JOAO, 5700) ));
	    	
	    	assertEquals(3, resultado.size());
	    	assertEquals(5400, resultado.get(0).getValor(), 0.00001);
	    	assertEquals(5500, resultado.get(1).getValor(), 0.00001);
	    	assertEquals(5700, resultado.get(2).getValor(), 0.00001);
	    }
	    
	    @Test
	    public void deveEliminarMenoresQue500() {
	    	FiltroDeLances filtro = new FiltroDeLances();
	    	List<Lance> resultado = filtro.filtra(Arrays.asList(
	    			new Lance(JOAO, 400),
	    			new Lance(JOAO, 200),
	    			new Lance(JOAO, 500),
	    			new Lance(JOAO, 501) ));
	    	
	    	assertEquals(1, resultado.size());
	    	assertEquals(501, resultado.get(0).getValor());
	    }
	    
	    @Test
	    public void deveEliminarEntre700E1000() {
	    	FiltroDeLances filtro = new FiltroDeLances();
	    	List<Lance> resultado = filtro.filtra(Arrays.asList(
	    			new Lance(JOAO, 800),
	    			new Lance(JOAO, 1000),
	    			new Lance(JOAO, 700),
	    			new Lance(JOAO, 1001) ));
	    	
	    	assertEquals(1, resultado.size());
	    	assertEquals(1001, resultado.get(0).getValor());
	    }
	    
	    @Test
	    public void deveEliminarEntre3000E5000() {
	    	FiltroDeLances filtro = new FiltroDeLances();
	    	List<Lance> resultado = filtro.filtra(Arrays.asList(
	    			new Lance(JOAO, 4000),
	    			new Lance(JOAO, 4500),
	    			new Lance(JOAO, 5000),
	    			new Lance(JOAO, 5001) ));
	    	
	    	assertEquals(1, resultado.size());
	    	assertEquals(5001, resultado.get(0).getValor());
	    }
	    
	    
	    
	    
	    
	    
}
