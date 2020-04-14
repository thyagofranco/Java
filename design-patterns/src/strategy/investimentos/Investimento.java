package strategy.investimentos;

import java.math.BigDecimal;

import domain.Conta;

public interface Investimento {
	
	BigDecimal investir(Conta conta);
}
