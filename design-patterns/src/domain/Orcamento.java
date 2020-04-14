package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import state.orcamento.EmAprovacao;
import state.orcamento.EstadoDeUmOrcamento;

public class Orcamento {
	
	private BigDecimal valor;
	private final List<Item> itens;
	private EstadoDeUmOrcamento estadoAtual;

	public Orcamento(BigDecimal valor) {
		this.valor = valor;
		this.itens = new ArrayList<Item>();
		this.estadoAtual = new EmAprovacao();
		
	}
	
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public List<Item> getItens() {
		return Collections.unmodifiableList(itens);
	}
	
	public void adicionaItem(Item item) {
		itens.add(item);
	}

	public void aplicaDescontoExtra() {
		this.estadoAtual.aplicaDescontoExtra(this);
	}
	
	public void aprova() {
		this.estadoAtual.aprova(this);
	}
	
	public void reprova() {
		this.estadoAtual.reprova(this);
	}
	
	public void finaliza() {
		this.estadoAtual.finalizar(this);
	}
	
	public EstadoDeUmOrcamento getEstadoAtual() {
		return estadoAtual;
	}
	
	public void setEstadoAtual(EstadoDeUmOrcamento estadoAtual) {
		this.estadoAtual = estadoAtual;
	}
}
