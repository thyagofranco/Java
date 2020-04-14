package template_method.chain_of_resposability.desconto;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chain_of_responsability.desconto.CalculadorDeDesconto;
import domain.Item;
import domain.Orcamento;

public class CalculadorDeDescontoTest {

	
	private Orcamento orcamento;
	private CalculadorDeDesconto descontos;
	
	@BeforeEach
	public void setup() {
		this.descontos = new CalculadorDeDesconto();
		
	}

	@Test
	public void naoDeveAplicarDescontoPorValorMenorDe500() {
		this.orcamento = new Orcamento(new BigDecimal(499));
		orcamento.adicionaItem(new Item("Caneta", new BigDecimal(250.00)));
		orcamento.adicionaItem(new Item("Relógio", new BigDecimal(249.00)));
		
		Assertions.assertEquals(BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_EVEN), 
				descontos.calcula(orcamento).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		
	}	
	
	@Test
	public void deveAplicarDescontoValorMaiorQueQuinhentos() {
		this.orcamento = new Orcamento(new BigDecimal(1000));
		orcamento.adicionaItem(new Item("Caneta", new BigDecimal(300.00)));
		orcamento.adicionaItem(new Item("Relógio", new BigDecimal(700.00)));
		
		Assertions.assertEquals(new BigDecimal(70.00).setScale(2, BigDecimal.ROUND_HALF_EVEN), 
				descontos.calcula(orcamento).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		
	}	
	
	@Test
	public void deveAplicarDescontoPorCincoItens() {
		this.orcamento = new Orcamento(new BigDecimal(70.00));
		orcamento.adicionaItem(new Item("Caneta", new BigDecimal(10.00)));
		orcamento.adicionaItem(new Item("Relógio", new BigDecimal(10.00)));
		orcamento.adicionaItem(new Item("Caneta", new BigDecimal(10.00)));
		orcamento.adicionaItem(new Item("Relógio", new BigDecimal(10.00)));
		orcamento.adicionaItem(new Item("Caneta", new BigDecimal(10.00)));
		orcamento.adicionaItem(new Item("Relógio", new BigDecimal(10.00)));
		orcamento.adicionaItem(new Item("Caneta", new BigDecimal(10.00)));
		
		Assertions.assertEquals(new BigDecimal(7.00).setScale(2, BigDecimal.ROUND_HALF_EVEN), 
				descontos.calcula(orcamento).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		
	}	
	
	@Test
	public void deveAplicarDescontoPorCincoItensNaoPorMaisQueValorQuinhentos() {
		this.orcamento = new Orcamento(new BigDecimal(700.00));
		orcamento.adicionaItem(new Item("Caneta", new BigDecimal(100.00)));
		orcamento.adicionaItem(new Item("Relógio", new BigDecimal(100.00)));
		orcamento.adicionaItem(new Item("Caneta", new BigDecimal(100.00)));
		orcamento.adicionaItem(new Item("Relógio", new BigDecimal(100.00)));
		orcamento.adicionaItem(new Item("Caneta", new BigDecimal(100.00)));
		orcamento.adicionaItem(new Item("Relógio", new BigDecimal(100.00)));
		orcamento.adicionaItem(new Item("Caneta", new BigDecimal(100.00)));
		
		Assertions.assertEquals(new BigDecimal(70.00).setScale(2, BigDecimal.ROUND_HALF_EVEN), 
				descontos.calcula(orcamento).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		
	}	
	
}
