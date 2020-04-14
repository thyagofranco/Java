package chain_of_responsability.requisicao;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Conta;
import domain.Formato;

public class ProcessadorRequisicaoTest {
	
	private ProcessadorRequisicao processadorRequisicao;
	private Conta conta;

	@BeforeEach
	public void setup() {
		this.processadorRequisicao = new ProcessadorRequisicao();
		this.conta = new Conta(new BigDecimal(100), "Thyago");
	}
	
	
	
	@Test
	public void deveProcessarRequisicaoSemFormato() {
		Requisicao requisicao = new Requisicao(null);
				
		Assertions.assertEquals("Formato não suportado", 
								processadorRequisicao.responde(requisicao, conta));
		
	}
	
	@Test
	public void deveProcessarRequisicaoNoFormatoXML() {
		Requisicao requisicao = new Requisicao(Formato.XML);
				
		Assertions.assertEquals("<conta><titular>Thyago</titular><saldo>100</saldo></conta>", 
								processadorRequisicao.responde(requisicao, conta));
		
	}
	
	@Test
	public void deveProcessarRequisicaoNoFormatoCSV() {
		Requisicao requisicao = new Requisicao(Formato.CSV);
				
		Assertions.assertEquals("conta;titular;Thyago;saldo;100", 
								processadorRequisicao.responde(requisicao, conta));
		
	}
	
	@Test
	public void deveProcessarRequisicaoNoFormatoPORCENTO() {
		Requisicao requisicao = new Requisicao(Formato.PORCENTO);
				
		Assertions.assertEquals("conta%titular%Thyago%saldo%100", 
								processadorRequisicao.responde(requisicao, conta));
		
	}

}
