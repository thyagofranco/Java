
package strategy.imposto;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Imposto;
import domain.Orcamento;
import strategy.imposto.ICCC;

public class ICCCTest {


	private Orcamento orcamento;

	@BeforeEach
	public void setup() {
		this.orcamento = new Orcamento(new BigDecimal(1000));
	}
	
	@Test
	public void deveCalcularICCC5PorCentoParaOrcamentoMenor1000() {
		Imposto iccc = new ICCC();
		orcamento.setValor(new BigDecimal(100.00));
		Assertions.assertEquals(new BigDecimal(100.00 * 0.05).setScale(2, BigDecimal.ROUND_HALF_EVEN), 
									iccc.calcula(orcamento).setScale(2,BigDecimal.ROUND_HALF_EVEN));
	} 
	
	@Test
	public void deveCalcularICCC7PorCentoParaOrcamentoEntre1000E3000ConsiderandoOsLimites() {
		Imposto iccc = new ICCC();
		orcamento.setValor(new BigDecimal(1000.00));
		Assertions.assertEquals(new BigDecimal(1000.00 * 0.07).setScale(2, BigDecimal.ROUND_HALF_EVEN), 
									iccc.calcula(orcamento).setScale(2,BigDecimal.ROUND_HALF_EVEN));
		
		orcamento.setValor(new BigDecimal(2000.00));
		Assertions.assertEquals(new BigDecimal(2000.00 * 0.07).setScale(2, BigDecimal.ROUND_HALF_EVEN), 
				iccc.calcula(orcamento).setScale(2,BigDecimal.ROUND_HALF_EVEN));
		
		orcamento.setValor(new BigDecimal(3000.00));
		Assertions.assertEquals(new BigDecimal(3000.00 * 0.07).setScale(2, BigDecimal.ROUND_HALF_EVEN), 
				iccc.calcula(orcamento).setScale(2,BigDecimal.ROUND_HALF_EVEN));
	} 
	
	@Test
	public void deveCalcularICCC8PorCentoMais30ParaOrcamentoAcimaDe3000() {
		Imposto iccc = new ICCC();
		orcamento.setValor(new BigDecimal(4000.00));
		Assertions.assertEquals(new BigDecimal((4000.00 * 0.08) + 30).setScale(2, BigDecimal.ROUND_HALF_EVEN), 
									iccc.calcula(orcamento).setScale(2,BigDecimal.ROUND_HALF_EVEN));
	}
	
	@Test
	public void deveCalcularICCC8PorCentoMais30ParaOrcamentoAcimaDe3000NumeroPequeno() {
		Imposto iccc = new ICCC();
		orcamento.setValor(new BigDecimal(3000.01));
		Assertions.assertEquals(new BigDecimal((3000.01 * 0.08) + 30).setScale(2, BigDecimal.ROUND_HALF_EVEN), 
									iccc.calcula(orcamento).setScale(2,BigDecimal.ROUND_HALF_EVEN));
	}
}
