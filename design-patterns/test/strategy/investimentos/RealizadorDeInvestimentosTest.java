package strategy.investimentos;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Conta;

public class RealizadorDeInvestimentosTest {

	private Conta conta;
	private RealizadorDeInvestimentos realizadorDeInvestimento;
	private Imposto imposto;
	
	@BeforeEach
	public void setup() {
		this.conta = new Conta(new BigDecimal(100));
		this.imposto = new Imposto();
		this.realizadorDeInvestimento = new RealizadorDeInvestimentos(imposto);
	
	}
	
	@Test
	public void deveRealizarUmInvestimentoConservador() {
		Investimento conservador = new Conservador();
		realizadorDeInvestimento.investir(conta, conservador);
		
		Assertions.assertEquals(new BigDecimal(100.60).setScale(2, BigDecimal.ROUND_HALF_EVEN), 
								conta.getSaldo().setScale(2,BigDecimal.ROUND_HALF_EVEN));
		
	}
	
	@Test
	public void deveRealizarUmInvestimentoModerado() {
		Investimento moderado = new Moderado();
		realizadorDeInvestimento.investir(conta, moderado);
		
		
		Assertions.assertTrue((conta.getSaldo().setScale(3,BigDecimal.ROUND_HALF_EVEN).compareTo(new BigDecimal(101.875).setScale(3,BigDecimal.ROUND_HALF_EVEN)) == 0)
							||(conta.getSaldo().setScale(3,BigDecimal.ROUND_HALF_EVEN).compareTo(new BigDecimal(100.525).setScale(3,BigDecimal.ROUND_HALF_EVEN)) == 0)
							);
		
	}
	
	@Test
	public void deveRealizarUmInvestimentoArrojado() {
		Investimento arrojado = new Arrojado();
		realizadorDeInvestimento.investir(conta, arrojado);
	
		Assertions.assertTrue((conta.getSaldo().setScale(3,BigDecimal.ROUND_HALF_EVEN).compareTo(new BigDecimal(103.750).setScale(3,BigDecimal.ROUND_HALF_EVEN)) == 0)
							||(conta.getSaldo().setScale(3,BigDecimal.ROUND_HALF_EVEN).compareTo(new BigDecimal(102.250).setScale(3,BigDecimal.ROUND_HALF_EVEN)) == 0)
							||(conta.getSaldo().setScale(3,BigDecimal.ROUND_HALF_EVEN).compareTo(new BigDecimal(100.450).setScale(3,BigDecimal.ROUND_HALF_EVEN)) == 0)
							);
				
	}
	
	
}
