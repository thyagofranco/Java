package template_method.impostos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Orcamento;
import template_method.impostos.ICPP;

public class ICPPTest {

	private Orcamento orcamento;
	private ICPP icpp;

	@BeforeEach
	public void setup() {
		this.orcamento = new Orcamento(new BigDecimal(501.00));
		this.icpp = new ICPP();
		
	}
	
	@Test
	public void deveCalcularMaximaTaxacao() {
		
	assertEquals(new BigDecimal(35.07).setScale(2, BigDecimal.ROUND_HALF_EVEN), 
							icpp.calcula(orcamento).setScale(2, BigDecimal.ROUND_HALF_EVEN));	
			
		
	}
	
	@Test
	public void deveCalcularMinimaTaxacao() {
		
	orcamento.setValor(new BigDecimal(500));
		
	assertEquals(new BigDecimal(25.00).setScale(2, BigDecimal.ROUND_HALF_EVEN), 
							icpp.calcula(orcamento).setScale(2, BigDecimal.ROUND_HALF_EVEN));	
			
		
	}
}
