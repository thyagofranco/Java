package template_method.impostos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Item;
import domain.Orcamento;
import template_method.impostos.IKCV;

public class IKCVTest {
	
	
	private IKCV ikcv;

	@BeforeEach
	public void setup() {
		this.ikcv = new IKCV();
	
	}
	
	@Test
	public void deveCalcularTaxacaoMaxima() {
		Orcamento orcamento = new Orcamento(new BigDecimal(501));
		orcamento.adicionaItem(new Item("Item 1", new BigDecimal(101)));
		orcamento.adicionaItem(new Item("Item 2", new BigDecimal(400)));
		assertEquals(new BigDecimal(50.10).setScale(2, BigDecimal.ROUND_HALF_EVEN),
						 ikcv.calcula(orcamento).setScale(2, BigDecimal.ROUND_HALF_EVEN));
	}
	
	@Test
	public void deveCalcularTaxacaoMinima() {
	
		Orcamento orcamento = new Orcamento(new BigDecimal(500));
		
		assertEquals(new BigDecimal(30.00).setScale(2, BigDecimal.ROUND_HALF_EVEN),
						 ikcv.calcula(orcamento).setScale(2, BigDecimal.ROUND_HALF_EVEN));
	}


}
