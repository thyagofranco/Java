package streams.methods;

import java.util.Arrays;
import java.util.List;

public class StreamBehavior {

	public static void main(String[] args) {
	
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,1,2,3,4,5);
		
		numbers.stream()
			   .filter(e -> e % 2 == 0)
			   .forEach(System.out::println);
			   
		//sized = came from a finite list 
		//ordered = List is ordered , first element, second ... index(0), index (1) ...
		//non-distinct = Have duplicates values
		//non-sorted = the values are not sorted
		

		
		numbers.stream()
			   .filter(e -> e % 2 == 0)
			   .sorted()
			   .forEach(System.out::println);
			   
		//sized = came from a finite list 
		//ordered = List is ordered , first element, second ... index(0), index (1) ...
		//non-distinct = Have duplicates values
		//sorted = the values are sorted
		
		numbers.stream()
		   .filter(e -> e % 2 == 0)
		   .sorted()
		   .distinct()
		   .forEach(System.out::println);
		   
	//sized = came from a finite list 
	//ordered = List is ordered , first element, second ... index(0), index (1) ...
	//distinct = Have duplicates values
	//sorted = the values are sorted
	}
	
}
