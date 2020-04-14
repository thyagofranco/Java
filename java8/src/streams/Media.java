package streams;

import java.util.List;
import java.util.OptionalDouble;

public class Media {

	public OptionalDouble calcula(List<Curso> cursos) {
		
		return cursos.stream()
					 .mapToInt(Curso::getAlunos)
					 .average();
	}

}
