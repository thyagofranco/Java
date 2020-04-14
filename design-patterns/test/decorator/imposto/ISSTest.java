package decorator.imposto;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Orcamento;

public class ISSTest {
	
	private Orcamento orcamento;

	@BeforeEach
	public void setup() {
		this.orcamento = new Orcamento(new BigDecimal(500));
		
	}
	
	@Test
	public void deveCalcularISSComICMS() {
		Imposto iss = new ISS(new ICMS());
		Assertions.assertEquals(new BigDecimal(80.00).setScale(2, BigDecimal.ROUND_HALF_EVEN), 
									iss.calcula(orcamento).setScale(2,BigDecimal.ROUND_HALF_EVEN));
	} 
	
	@Test
	public void deveCalcularISS() {
		Imposto iss = new ISS();
		Assertions.assertEquals(new BigDecimal(30.00).setScale(2, BigDecimal.ROUND_HALF_EVEN), 
									iss.calcula(orcamento).setScale(2,BigDecimal.ROUND_HALF_EVEN));
	}
	
	@Test
	public void deveCalcularISSComICPP() {
		Imposto iss = new ISS(new ICPP());
		Assertions.assertEquals(new BigDecimal(55.00).setScale(2, BigDecimal.ROUND_HALF_EVEN), 
									iss.calcula(orcamento).setScale(2,BigDecimal.ROUND_HALF_EVEN));
	} 

}
