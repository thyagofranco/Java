package domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import state.conta.EstadoConta;
import state.conta.Negativa;
import state.conta.Positiva;

public class Conta {

	private BigDecimal saldo;
	private String nomeTitular;
	private String agencia;
	private String numero;
	private LocalDate dataAbertura;
	private EstadoConta estadoDaConta;


	public Conta() {}
	
	public Conta(BigDecimal saldo) {
		if(!(saldo.compareTo(saldo) >= 0)) throw new RuntimeException("Conta deve ser inicializada com saldo positivo");
		
		this.saldo = saldo;
		this.estadoDaConta = new Positiva();
	}
	
	public Conta(BigDecimal saldo, String nomeTitular) {
		if(!(saldo.compareTo(saldo) >= 0)) throw new RuntimeException("Conta deve ser inicializada com saldo positivo");
		
		this.saldo = saldo;
		this.nomeTitular = nomeTitular;
		this.estadoDaConta = new Positiva();
	}
	
	public Conta(BigDecimal saldo, LocalDate dataAbertura) {
		if(!(saldo.compareTo(saldo) >= 0)) throw new RuntimeException("Conta deve ser inicializada com saldo positivo");
		
		this.saldo = saldo;
		this.dataAbertura = dataAbertura;
		this.estadoDaConta = new Positiva();
	}
		
		
	public BigDecimal getSaldo() {
		return saldo;
	}

	public void deposita(BigDecimal valor) {
		valor = this.getEstadoDaConta().deposita(valor, this);
		this.saldo = this.saldo.add(valor);
	}
		
	public void saca(BigDecimal valor) {
		valor = this.getEstadoDaConta().saca(valor, this);
		this.saldo = this.saldo.subtract(valor);
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public EstadoConta getEstadoDaConta() {
		return estadoDaConta;
	}
	
	public void positivarConta() {
		this.estadoDaConta = new Positiva();
	}
	public void negativarConta() {
		this.estadoDaConta = new Negativa();
		
	}

	
}
