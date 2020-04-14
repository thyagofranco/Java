package streams.methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Exemplo {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		numbers.stream()
			   .filter(e -> e % 2 ==0);
		
		//filter: 0 <= number of elements in the output <= number of input
		//input: Stream<T> filter takes Predicate<T>
		
		
		//map transforms values
		//numbers of output == numbers of input
		//no guarantee on the type of the output with respect to the type of the input
		//parameter: Stream<T> map takes Function<T, R> to return Stream<R>
		
		numbers.stream()
		   .filter(e -> e % 2 ==0)
		   .map(e -> e * 2.0);     //Input Stream<Integer>    after map()  Output  Stream<Double>
		  
				
		//Reduce carrega valores de uma iteracao para o input da proxima iteracao
		//Reduce pode transformar uma coleção em um único valor ou em um objeto concreto.  
		 
		//reduce trabalha levando o resultado de cada iteração para a próxima iteração.
		//reduce Stream<T> takes two parameters:
		//first parameter is of type T
		//second parameter is of type BiFunction<R, T, R> to produce a result of R;
		//BiFunction<element type, input type , output type>
		numbers.stream()
			   .filter(e -> e % 2 ==0)
			   .map(e -> e * 2.0)
			   .reduce(0.0, (accumulator, element) -> accumulator + element);
		
		//especialized reduce
		numbers.stream()
		   .filter(e -> e % 2 ==0)
		   .mapToDouble(e -> e * 2.0)
		   .sum();
		
		//collect é um tipo de Reduce
		List<Integer> repeatedNumbers = Arrays.asList(1,2,3,4,5,1,2,3,4,5);
		
		//double the even values and put that into a list.
		
		//wrong way to do : 
		
		List<Integer> doubleOfEven = new ArrayList<>();
		
		//Don't do this  (Concurrency problems an race conditions on parralel)
		repeatedNumbers.stream()
						.filter(e -> e % 2 == 0)
						.map(e -> e * 2)
						.forEach(e -> doubleOfEven.add(e));  //shared mutability is evil
		
		
		System.out.println(doubleOfEven); 

		List<Integer> doubleOfEven2 = repeatedNumbers.stream()
													.filter(e -> e % 2 == 0)
													.map(e -> e * 2)
													.collect(Collectors.toList());  //collect is thread safe
		
		System.out.println(doubleOfEven2);
		
		
		
		Set<Integer> doubleOfEvenSet = repeatedNumbers.stream()
				.filter(e -> e % 2 == 0)
				.map(e -> e * 2)
				.collect(Collectors.toSet());  //collect is thread safe

		System.out.println(doubleOfEvenSet);
											
		
		
	}

}
