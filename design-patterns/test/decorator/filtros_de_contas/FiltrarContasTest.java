package decorator.filtros_de_contas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Conta;

public class FiltrarContasTest {

	private List<Conta> contas;

	@BeforeEach
	public void setup() {
		this.contas = Arrays.asList(
				new Conta(new BigDecimal(99.00), LocalDate.now().minus(2, ChronoUnit.MONTHS )),
				new Conta(new BigDecimal(501000.00), LocalDate.now().minus(2, ChronoUnit.MONTHS )),
				new Conta(new BigDecimal(101.00), LocalDate.now()),
				new Conta(new BigDecimal(101.00), LocalDate.now().minus(2, ChronoUnit.MONTHS ))
				);
	}
	
	@Test
	public void deveFiltrarContasComSaldoMenorCemReais() {
		Filtro filtroMenorDeCemReais = new FiltroMenorDeCemReais();
		assertEquals(1, filtroMenorDeCemReais.filtrar(contas).size());
		assertEquals(contas.get(0).getSaldo().setScale(2, BigDecimal.ROUND_HALF_EVEN),
				     filtroMenorDeCemReais.filtrar(contas).get(0).getSaldo().setScale(2, BigDecimal.ROUND_HALF_EVEN));
	}
	
	
	@Test
	public void deveFiltrarContasComSaldoMaior500Mil() {
		Filtro filtroMaiorQuinhentosMilReais = new FiltroMaiorQuinhentosMilReais();
		assertEquals(1, filtroMaiorQuinhentosMilReais.filtrar(contas).size());
		assertEquals(contas.get(1).getSaldo().setScale(2, BigDecimal.ROUND_HALF_EVEN),
			     filtroMaiorQuinhentosMilReais.filtrar(contas).get(0).getSaldo().setScale(2, BigDecimal.ROUND_HALF_EVEN));
	}
	
	@Test
	public void deveFiltrarContasDataAberturaMesCorrente() {
		Filtro filtroDataAberturaMesCorrente = new FiltroDataAberturaMesCorrente();
		assertEquals(1, filtroDataAberturaMesCorrente.filtrar(contas).size());
		assertEquals(contas.get(2).getDataAbertura(), filtroDataAberturaMesCorrente.filtrar(contas).get(0).getDataAbertura());
	}
	
	@Test
	public void deveFiltrarContasComSaldoMenorCemReaisMaisContasSaldoMaior500MilMaisContasDataAberturaMesCorrente() {
		Filtro filtroMenorDeCemReais = new FiltroMenorDeCemReais();
		Filtro filtroMaiorQuinhentosMilReais = new FiltroMaiorQuinhentosMilReais(filtroMenorDeCemReais);
		Filtro filtroDataAberturaMesCorrente = new FiltroDataAberturaMesCorrente(filtroMaiorQuinhentosMilReais);
		assertEquals(3, filtroDataAberturaMesCorrente.filtrar(contas).size());
		assertEquals(contas.get(0).getSaldo().setScale(2, BigDecimal.ROUND_HALF_EVEN),
			     filtroMenorDeCemReais.filtrar(contas).get(0).getSaldo().setScale(2, BigDecimal.ROUND_HALF_EVEN));
		assertEquals(contas.get(1).getSaldo().setScale(2, BigDecimal.ROUND_HALF_EVEN),
			     filtroMaiorQuinhentosMilReais.filtrar(contas).get(0).getSaldo().setScale(2, BigDecimal.ROUND_HALF_EVEN));
		assertEquals(contas.get(2).getDataAbertura(), filtroDataAberturaMesCorrente.filtrar(contas).get(0).getDataAbertura());
	}
	
}
