package streams;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MediaTest {

	private List<Curso> cursos;

	@BeforeEach
	public void setup() {
		this.cursos = Arrays.asList(
				new Curso("JavaScript", 150),
				new Curso("Java 8", 113),
				new Curso("Python", 45),
				new Curso("C", 55)
				
				);
	}
	
	@Test
	public void deveRetornarMediaAlunosCadastradosEmTodosOsCursos() {
		
		Media media = new Media();
		
				
		Assertions.assertEquals(90.75, media.calcula(cursos));
		
	}
}
