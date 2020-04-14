package br.com.caelum.fizzbuzz;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FizzBuzz {
	private final String FIZZ = "Fizz";
	private String BUZZ = "Buzz";
	
	public String execute(int[] numbers) {
		return Arrays.stream(numbers).mapToObj(this::processNumber).collect(Collectors.joining(", "));
	}

	public String processNumber(int integer) {
		if(isMultipleOf3(integer) && isMultipleOf5(integer)) return FIZZ+BUZZ;
		if(isMultipleOf3(integer) ) return FIZZ;
		if(isMultipleOf5(integer)) return BUZZ ;
		
		return String.valueOf(integer);
	}

	private boolean isMultipleOf5(int integer) {
		return integer % 5 == 0;
	}

	private boolean isMultipleOf3(int integer) {
		return integer % 3 == 0;
	}
}
