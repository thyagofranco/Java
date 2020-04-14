package default_methods;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class OrdenaStrings {

	
	public List<String> ordenaLexicograficoAntigo(List<String> palavras){
		
		Collections.sort(palavras);
		return palavras;
	}
	
	
	public List<String> ordenaPorTamanhoAntigo(List<String> palavras){
		Comparator<String> comparador = new ComparadorPorTamanho();
		
		Collections.sort(palavras, comparador);
		return palavras;
	}
	
	//Interface list tem uma default method sort
	public List<String> ordenaPorTamanho(List<String> palavras){
		Comparator<String> comparador = new ComparadorPorTamanho();
		palavras.sort(comparador);
		return palavras ;
	}
	
	
}
