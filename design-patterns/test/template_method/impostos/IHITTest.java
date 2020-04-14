package template_method.impostos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Item;
import domain.Orcamento;
import template_method.impostos.IHIT;

public class IHITTest {
	
	private IHIT ihit;
	private Orcamento orcamento;

	@BeforeEach
	public void setup() {
		this.ihit = new IHIT();
		this.orcamento = new Orcamento(new BigDecimal(100));
	}
	
	
	@Test
	public void deveTestarImpostoMaximo2ItemMesmoNome() {
		
		orcamento.adicionaItem(new Item("relogio", new BigDecimal(25)));
		orcamento.adicionaItem(new Item("relogio", new BigDecimal(25)));
		orcamento.adicionaItem(new Item("carta", new BigDecimal(25)));
		orcamento.adicionaItem(new Item("cabide", new BigDecimal(25)));
		
		assertEquals(new BigDecimal(113).setScale(2, BigDecimal.ROUND_HALF_EVEN),
					 ihit.calcula(orcamento).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		
	}
	
	@Test
	public void deveTestarImpostoMinimo() {
		
		orcamento.adicionaItem(new Item("relogio", new BigDecimal(25)));
		orcamento.adicionaItem(new Item("relogio de parede", new BigDecimal(25)));
		orcamento.adicionaItem(new Item("carta", new BigDecimal(25)));
		orcamento.adicionaItem(new Item("cabide", new BigDecimal(25)));
		
		assertEquals(new BigDecimal(4).setScale(2, BigDecimal.ROUND_HALF_EVEN),
					 ihit.calcula(orcamento).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		
	}
	
	
}
