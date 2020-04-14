package strategy.investimentos;

import java.math.BigDecimal;
import java.util.Random;

import domain.Conta;

public class Arrojado implements Investimento{

	@Override
	public BigDecimal investir(Conta conta) {
		
		
		int probabilidade = new Random().nextInt(10); 
		
		if(probabilidade <= 0.20) return conta.getSaldo().multiply(new BigDecimal(0.05));
		
		if((probabilidade > 0.20) && (probabilidade <= 0.50)) return conta.getSaldo().multiply(new BigDecimal(0.03));
		
		return conta.getSaldo().multiply(new BigDecimal(0.006));
	}

}
