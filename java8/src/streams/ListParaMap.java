package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListParaMap {
public static void main(String[] args) {
		
		List<Curso> cursos = Arrays.asList(
				new Curso("JavaScript", 150),
				new Curso("Java 8", 113),
				new Curso("Python", 45),
				new Curso("C", 55)
				
				);
		
		
		Map<String, Integer> mapaCursosMais100Alunos = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toMap(Curso::getNome, Curso::getAlunos));
		
		
		System.out.println(mapaCursosMais100Alunos);
		
		cursos.stream()
		.filter(c -> c.getAlunos() >= 100)
		.collect(Collectors.toMap(Curso::getNome, Curso::getAlunos))
		.forEach((nome, alunos)-> System.out.println(nome + " tem " + alunos + " alunos" ));
		
		
		
	}

	
}
