package streams.methods;

import java.util.Arrays;
import java.util.List;

public class Performance {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
		
		//given an ordered list find the double of the first even number greater than 3
		
		
		//Imperative    ugly but only 8 units of work
		int result = 0;
		
		for (Integer e : numbers) {
			if(e > 3 && e % 2 == 0) {
				result = e * 2;
				break;
			}
		}
		
		//Declarative functional
		System.out.println(result);
		
		System.out.println(
				numbers.stream()
					   .filter(e -> e > 3)
					   .filter(e -> e % 2 == 0)
					   .map(e -> e * 2)
					   .findFirst()
				
				);
		

		
		
		//Declarative functional refactory to performance
		
		
		//Lazy evaluation
		//All steps of the pipeline are lazy, the dont do any work until you call some step that create a concret object;
		
		//Stream don't apply filter in all values, if index 0 pass in filter, then this value go to next pipeline and so on
		// Apply the entire pipiline in the element
		
		//Don't do anything else of make the pipeline
				System.out.println(
						numbers.stream()
							   .filter(Performance::isGT3)   
							   .filter(Performance::isEven)  
							   .map(Performance::doubleIt)                 
						
						);	
				System.out.println("Done");
				
		//Do becouse findFirst()
		System.out.println(
				numbers.stream()
					   .filter(Performance::isGT3)   
					   .filter(Performance::isEven)  
					   .map(Performance::doubleIt)   
					   .findFirst()                  
				
				);
	
	}
	
	//For visualization of Lazy evaluation
	// Don't do this, becouse the side-effects
	
	public static boolean isGT3(int number) {
		System.out.println("isGT3" + number);
		return number > 3;
	}
	
	public static boolean isEven(int number) {
		System.out.println("isEven" + number);
		return number % 2 == 0;
	}
	
	public static int doubleIt(int number) {
		System.out.println("Dobrando" + number);
		return number * 2;
	}
}
