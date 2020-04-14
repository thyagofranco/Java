package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ImprimeForEach {
	
	public static void main(String[] args) {
		
		List<String> palavras = Arrays.asList("editora casa do codigo",
				  "caelum",
				  "alura online");
		
		
		for (String p : palavras) {
			System.out.println(p);
		}
		
		//Classe anonima de Consumer	
		palavras.forEach(new Consumer<String>() {

			@Override
			public void accept(String s) {
				System.out.println(s);
				
			}
		});
				
		
		palavras.forEach((s) -> System.out.println(s));
		
		palavras.forEach(System.out::println);
	}
				
}

