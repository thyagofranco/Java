package strategy.investimentos;

import java.math.BigDecimal;
import java.util.Random;

public class Moderado implements Investimento {

	@Override
	public BigDecimal investir(Conta conta) {
		
		int probabilidade = new Random().nextInt();
		if(probabilidade <= 0.5) return conta.getSaldo().multiply(new BigDecimal(0.025));
		
		return conta.getSaldo().multiply(new BigDecimal(0.007));
	}

}