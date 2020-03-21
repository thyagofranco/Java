package strategy.investimentos;

import java.math.BigDecimal;

public class Conta {

	private BigDecimal saldo;

	public Conta() {}
	
	public Conta(BigDecimal saldo) {
		this.saldo = saldo;
	}
		
	public BigDecimal getSaldo() {
		return saldo;
	}

	public void deposita(BigDecimal saldo) {
		this.saldo = this.saldo.add(saldo);
	}
	
	
	 
}
