package state.orcamento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Orcamento;
import state.orcamento.ErroDescontoDuplicado;
import state.orcamento.ErroEstadoObjeto;

public class DescontoExtraTest {

	private Orcamento orcamento;

	@BeforeEach
	public void setup() {
		this.orcamento = new Orcamento(new BigDecimal(500));
	}
	
	@Test
	public void deveAplicarDescontoExtraOrcamentoAberto() {
		orcamento.aplicaDescontoExtra();
		assertEquals(new BigDecimal(475).setScale(2, BigDecimal.ROUND_HALF_EVEN),
				     orcamento.getValor().setScale(2, BigDecimal.ROUND_HALF_EVEN));
	}
	
	@Test
	public void deveAplicarDescontoExtraOrcamentoAprovado() {
		orcamento.aprova();
		orcamento.aplicaDescontoExtra();
		
		assertEquals(new BigDecimal(490).setScale(2, BigDecimal.ROUND_HALF_EVEN),
				   	 orcamento.getValor().setScale(2, BigDecimal.ROUND_HALF_EVEN));
	}
	
	@Test
	public void naoDeveAplicarDescontoExtraOrcamentoFinalizado(){
		assertThrows(ErroEstadoObjeto.class, ()-> { 
			orcamento.reprova();
			orcamento.finaliza();	
			orcamento.aplicaDescontoExtra();
		});
	}
	
	@Test
	public void naoDevePermitirOrcamentoEmAbertoSerFinalizado(){
		assertThrows(ErroEstadoObjeto.class, ()-> { 
			orcamento.finaliza();	
		});
	}
	
	@Test
	public void naoDevePermitirAplicacaoDeDescontoDuplicadaEmEstadoEmAberto() {
		assertThrows(ErroDescontoDuplicado.class, ()-> { 
			orcamento.aplicaDescontoExtra();
			orcamento.aplicaDescontoExtra();
		});
	}
	
	@Test
	public void naoDevePermitirAplicacaoDeDescontoDuplicadaEmEstadoAprovado() {
		assertThrows(ErroDescontoDuplicado.class, ()-> { 
			orcamento.aprova();
			orcamento.aplicaDescontoExtra();
			orcamento.aplicaDescontoExtra();
		});
	}
	
}
