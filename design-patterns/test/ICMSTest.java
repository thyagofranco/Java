import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ICMSTest {

	private Orcamento orcamento;

	@BeforeEach
	public void setup() {
		this.orcamento = new Orcamento(new BigDecimal(1000));
		
	}
	
	@Test
	public void deveCalcularICMS10PorCento() {
		Imposto icms = new ICMS();
		
		Assertions.assertEquals(new BigDecimal(100.00).setScale(2, BigDecimal.ROUND_HALF_EVEN), 
									icms.calcula(orcamento).setScale(2,BigDecimal.ROUND_HALF_EVEN));
	} 
}
