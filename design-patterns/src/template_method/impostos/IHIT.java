package template_method.impostos;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import domain.Item;
import domain.Orcamento;

public class IHIT extends TemplateDeImpostoCondicional{

	@Override
	protected boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
//		List<Item> itens = orcamento.getItens();
//		
//		for (Item item : itens) {
//			int duplicados = 0;
//			String nome = item.getNome();
//			for (Item comparado : itens) {
//				if(comparado.getNome().equals(nome)) duplicados++; 
//			}
//			if(duplicados > 1) return true;
//		}
//		
//		return false;
		
		
//	    List<String> noOrcamento = new ArrayList<String>();
//
//        for(Item item : orcamento.getItens()) {
//          if(noOrcamento.contains(item.getNome())) return true;
//          else noOrcamento.add(item.getNome());
//        }
//
//        return false;
		
		List<String> nomesProdutos = orcamento.getItens().stream()
				.map(Item::getNome)
				.collect(Collectors.toList());
		Set<String> nomesProdutosSemDuplicados = orcamento.getItens().stream()
				.map(Item::getNome)
				.collect(Collectors.toSet());
		return nomesProdutos.size() != nomesProdutosSemDuplicados.size() ? true : false;
				    
				        
				        
	}

	@Override
	protected BigDecimal maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal(0.13)).add(new BigDecimal(100));
	}

	@Override
	protected BigDecimal minimaTaxacao(Orcamento orcamento) {
		return  orcamento.getValor().multiply(new BigDecimal((orcamento.getItens().size() / 100.0)));
	}
	

}
