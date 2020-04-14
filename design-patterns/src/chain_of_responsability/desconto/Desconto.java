package chain_of_responsability.desconto;
import java.math.BigDecimal;

import domain.Orcamento;

public interface Desconto {

	BigDecimal desconta(Orcamento orcamento);
	
	void setProximo(Desconto proximo);
}
