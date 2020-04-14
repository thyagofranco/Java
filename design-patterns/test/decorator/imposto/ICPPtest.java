package decorator.imposto;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Orcamento;

public class ICPPtest {


	private Orcamento orcamento;

	@BeforeEach
	public void setup() {
		this.orcamento = new Orcamento(new BigDecimal(500));
		
	}
	
	@Test
	public void deveCalcularICPPComISS() {
		Imposto iss = new ICPP(new ISS());
		Assertions.assertEquals(new BigDecimal(55.00).setScale(2, BigDecimal.ROUND_HALF_EVEN), 
									iss.calcula(orcamento).setScale(2,BigDecimal.ROUND_HALF_EVEN));
	} 
}
