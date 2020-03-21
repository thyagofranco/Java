import java.math.BigDecimal;

public class ICCC implements Imposto{

	@Override
	public BigDecimal calcula(Orcamento orcamento) {
		
		if(orcamento.getValor().compareTo(new BigDecimal(1000)) == -1) return orcamento.getValor().multiply(new BigDecimal(0.05));
		
		if(orcamento.getValor().compareTo(new BigDecimal(3000)) == -1 || 
		   orcamento.getValor().compareTo(new BigDecimal(3000)) == 0) return orcamento.getValor().multiply(new BigDecimal(0.07));
				
		return (orcamento.getValor().multiply(new BigDecimal(0.08)).add(new BigDecimal(30)));
		
	}
	

}
