package streams.methods;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReduceToMap {

	public static void main(String[] args) {
		List<Person> people = Person.createPeople();
		
		//create a Map with name and age as key, and the person as value
		
		System.out.println(
		people.stream()
			  .collect(Collectors.toMap(
					  person -> person.getName() + "-" + person.getAge(),
					  person -> person
					  ))		
		);
		
		
		//given a list of people, create a map where their name is the key 
		//and value is all the people whit that name
		
		System.out.println(
				people.stream()
				      .collect(Collectors.groupingBy(Person::getName))
								
				);
		
		//given a list of people, create a map where their name is the key 
		//and value is all the ages of people whit that name
		
		System.out.println(
				people.stream()
				      .collect(Collectors.groupingBy(Person::getName, 
				    		   Collectors.mapping(Person::getAge, Collectors.toList())))
								
				);
	
	
	}
	
}

class Person {
	
	private String name;
	private Gender gender;
	private int age;
	
	public Person(String name, Gender gender, int age) {
	
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	public static List<Person> createPeople(){
		return  Arrays.asList(
				new Person("Sara", Gender.FEMALE, 20),
				new Person("Sara", Gender.FEMALE, 22),
				new Person("Bob", Gender.MALE, 20),
				new Person("Paula", Gender.FEMALE, 32),
				new Person("Paul", Gender.MALE, 32),
				new Person("Jack", Gender.MALE, 2),
				new Person("Jack", Gender.MALE, 70),
				new Person("Jill", Gender.FEMALE, 12)

				);
	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
	
	
	
}

enum Gender {
	FEMALE,MALE
}