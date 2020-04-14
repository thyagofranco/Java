package state.conta;

import java.math.BigDecimal;

import domain.Conta;

public interface EstadoConta {

	BigDecimal deposita(BigDecimal valor, Conta conta);
	BigDecimal saca(BigDecimal valor, Conta conta);
}
