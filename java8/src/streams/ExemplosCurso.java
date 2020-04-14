package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ExemplosCurso {

	public static void main(String[] args) {
		List<Curso> cursos = Arrays.asList(
				new Curso("JavaScript", 150),
				new Curso("Java 8", 113),
				new Curso("Python", 45),
				new Curso("C", 55)
				
				);
		
		
		//Imprimir os cursos ordenados por numero de alunos
		
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		
		// cursos.forEach(System.out::println);   Só consegue imprimir o toString() do objeto 
		
		cursos.forEach(c -> System.out.println(c.getNome()));
		
		System.out.println("========");
		//Imprimir todos os cursos com mais de 100 alunos.
		
		
		
		cursos.stream()  //cursos.parallelStream() 
			  .filter(c -> c.getAlunos() > 100)
			  .forEach(c -> System.out.println(c.getNome()));
		
		
		System.out.println("========");
		//Imprimir a quantidade de alunos de cada curso.
		
		cursos.stream()
			  .filter(c -> c.getAlunos() > 100)
//			  .map(c -> c.getAlunos())
//		      .forEach(numAlunos -> System.out.println(numAlunos));
			  	
			  .map(Curso::getAlunos)
			  .forEach(System.out::println);
		
		
		//Utilizando um IntStream
		System.out.println("========");
		int sum = cursos.stream()
		      .filter(c -> c.getAlunos() > 100)
		      .mapToInt(Curso::getAlunos)
		      .sum();
		
		System.out.println(sum);
		
		
	}
	
}
