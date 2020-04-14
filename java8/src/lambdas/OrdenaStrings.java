package lambdas;

import java.util.Comparator;
import java.util.List;

public class OrdenaStrings {

	public List<String> ordenaPorTamanhoSemLambda(List<String> palavras) {

		palavras.sort(new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				if (s1.length() < s2.length())
					return -1;
				if (s1.length() > s2.length())
					return 1;
				return 0;
			}
		});
		return palavras;
	}

//	public List<String> ordenaPorTamanho(List<String> palavras){
//					
//			palavras.sort((String s1, String s2) -> {
//				if(s1.length() < s2.length()) return -1;
//				if(s1.length() > s2.length()) return 1;
//				return 0;
//			});
//			
//			return palavras;
//	
//	}

	public List<String> ordenaPorTamanho(List<String> palavras){
		
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		return palavras;

}

}
