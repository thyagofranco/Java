package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExemploCollect {
	public static void main(String[] args) {
		List<Curso> cursos = Arrays.asList(
				new Curso("JavaScript", 150),
				new Curso("Java 8", 113),
				new Curso("Python", 45),
				new Curso("C", 55)
				
				);
		
		
		List<Curso> cursosComMaisDe100Alunos = cursos.stream()
			  .filter(c -> c.getAlunos() >= 100)
			  .collect(Collectors.toList());
	}
}
