package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Consumer;

import javax.print.attribute.standard.Media;

public class ExemploOptional {

	public static void main(String[] args) {
		
		List<Curso> cursos = Arrays.asList(
				new Curso("JavaScript", 150),
				new Curso("Java 8", 113),
				new Curso("Python", 45),
				new Curso("C", 55)
				
				);
		
			
		
		Optional<Curso> optionalCurso = cursos.stream().filter(c-> c.getAlunos() >=1000).findAny();
		
		optionalCurso.ifPresent(c -> System.out.println(c.getNome()));
		
		Curso curso = optionalCurso.orElse(cursos.get(0));
		System.out.println(curso.getNome());
		
		cursos.stream()
			  .filter(c -> c.getAlunos() >= 100)
			  .findAny()
			  .ifPresent(c -> System.out.println(c.getNome()));
		
		
		// a Stream devolve um OptionalDouble e evita uma possível divisão por zero, etc..
		OptionalDouble media = cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.mapToInt(Curso::getAlunos)
				.average();
		
		
		
	}
}
