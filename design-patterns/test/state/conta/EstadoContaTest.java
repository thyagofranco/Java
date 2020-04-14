package state.conta;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Conta;

public class EstadoContaTest {
	
	private Conta conta;

	@BeforeEach
	public void setup() {
		this.conta = new Conta(BigDecimal.ZERO);
	}
	
	@Test
	public void devePositivarUmaContaNegativa() {
		conta.deposita(new BigDecimal(500));
		conta.saca(new BigDecimal(1000));
		conta.deposita(new BigDecimal(600));
		
		Assertions.assertTrue(conta.getEstadoDaConta() instanceof Positiva);
		
		
	}
	
	@Test
	public void deveNegativarUmaContaPositiva() {
		
	}

}
