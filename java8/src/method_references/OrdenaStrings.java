package method_references;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OrdenaStrings {

	public static void main(String[] args) {
		
		List<String> palavras = Arrays.asList("editora casa do codigo",
				  "caelum",
				  "alura online");
		
// Whitout Lambda
//		Function<String, Integer> funcao =new Function<String, Integer>() {
//
//			@Override
//			public Integer apply(String s) {
//				
//				return s.length();
//			}
//		};
//		Comparator<String> comparador = Comparator.comparing(funcao);
//		palavras.sort(comparador);
		

// Whit Lambda		
//		palavras.sort(Comparator.comparing(s -> s.length()));
		

//Whit Lambda and Method Reference
		
		palavras.sort(Comparator.comparing(String::length));
		
		palavras.forEach(System.out::println);
	}
}
