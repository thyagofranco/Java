import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ISSTest {
	private Orcamento orcamento;

	@BeforeEach
	public void setup() {
		this.orcamento = new Orcamento(new BigDecimal(1000));
		
	}
	
	@Test
	public void deveCalcularISS6PorCento() {
		Imposto iss = new ISS();
		Assertions.assertEquals(new BigDecimal(60.00).setScale(2, BigDecimal.ROUND_HALF_EVEN), 
									iss.calcula(orcamento).setScale(2,BigDecimal.ROUND_HALF_EVEN));
	} 
}
