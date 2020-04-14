package decorator.imposto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Orcamento;

public class ImpostoMuitoAltoTest {

	
	private Orcamento orcamento;

	@BeforeEach
	public void setup() {
		this.orcamento = new Orcamento(new BigDecimal(500));
	}
	
	@Test
	public void deveCalcularImpostoMuitoAlto() {
		
		Imposto impostoMuitoAlto = new ImpostoMuitoAlto();
		
		assertEquals(new BigDecimal(100).setScale(2, BigDecimal.ROUND_HALF_EVEN),
					 impostoMuitoAlto.calcula(orcamento).setScale(2, BigDecimal.ROUND_HALF_EVEN));
	}
	
	
	@Test
	public void deveCalcularImpostoMuitoAltoComICMS() {
		Imposto impostoMuitoAltoMaisICMS = new ImpostoMuitoAlto(new ICMS());
		
		assertEquals(new BigDecimal(150).setScale(2, BigDecimal.ROUND_HALF_EVEN),
				impostoMuitoAltoMaisICMS.calcula(orcamento).setScale(2, BigDecimal.ROUND_HALF_EVEN));
	}
}
