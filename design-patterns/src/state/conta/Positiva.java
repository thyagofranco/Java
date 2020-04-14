package state.conta;

import java.math.BigDecimal;

import domain.Conta;

public class Positiva implements EstadoConta{

	@Override
	public BigDecimal deposita(BigDecimal valor, Conta conta) {
		
		return valor.multiply(new BigDecimal(0.98));
	}

	@Override
	public BigDecimal saca(BigDecimal valor, Conta conta) {
		if(contaFicaraNegativa(valor, conta)) {
			conta.negativarConta();
		}
		
		return valor;
	}

	private boolean contaFicaraNegativa(BigDecimal valor, Conta conta) {
		return conta.getSaldo().subtract(valor).compareTo(BigDecimal.ZERO) < 0 ? true: false;
	}

	

	
}

	

