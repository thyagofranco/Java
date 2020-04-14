package domain;

import java.math.BigDecimal;

public interface Imposto {
	
	BigDecimal calcula(Orcamento orcamento);
}
