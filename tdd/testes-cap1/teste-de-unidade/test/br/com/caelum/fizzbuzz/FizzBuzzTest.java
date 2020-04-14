package br.com.caelum.fizzbuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {

	private FizzBuzz fizzBuzz;
	
	@BeforeEach
	public void setup() {
		this.fizzBuzz = new FizzBuzz();
	}
	
	@Test
	public void shouldProcessInput() {
		
		assertEquals("1", fizzBuzz.processNumber(1));
		assertEquals("2", fizzBuzz.processNumber(2));
		assertEquals("Fizz", fizzBuzz.processNumber(3));
		assertEquals("Buzz", fizzBuzz.processNumber(5));
		assertEquals("Fizz", fizzBuzz.processNumber(6));
		assertEquals("Buzz", fizzBuzz.processNumber(10));
		assertEquals("FizzBuzz", fizzBuzz.processNumber(15));
	}
	
	@Test
	public void shouldExecute() {
		assertEquals("1", fizzBuzz.execute(new int[] {1}));
		assertEquals("1, 2, Fizz, Buzz, Fizz, Buzz, FizzBuzz, FizzBuzz", fizzBuzz.execute(new int[] {1,2,3,5,6,10,15,30}));
	}
	
}
