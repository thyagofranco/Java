Java 8  (2014)

Default Methods: 
===============

Interfaces podem ter métodos concretos.

```java
public interface List{
    default void sort(Comparator<? super E> c){
        Collections.sort(this, c);
    }
}
``` 

Permite a evolução de uma interface sem quebrar as classes antigas que a implementavam sem os novos métodos.

Uma interface com métodos default não é como uma classe Abstrata, a classe abstrata por ter atributos (pode ter estado), uma interface não.


Lambdas: 
===============
Funciona sempre que temos uma Interface Funcional.

Interface Funcional:
Deve ter 1 único método abstrato. Além desse método ela pode ter outros métodos, contanto que sejam default ou 'static'. Essa estrutura é fundamental, pois assim o compilador sabe exatamente que o corpo da expressão lambda que escrevemos é a implementação de seu único método abstrato

Para uma função lambda se encaixar no código:
- Deve subtituir uma interface funcional
- Deve receber os mesmos argumentos e retornar os mesmos parâmetros compatíveis com a interface funcional.


Side note : Generics: 
-----------
class A { }
class B extends A { }
class C extends B { }
List<? extends T> - reading and assigning:

|-------------------------|-------------------|---------------------------------|
|         wildcard        |        get        |              assign             |
|-------------------------|-------------------|---------------------------------|
|    List<? extends C>    |    A    B    C    |                       List<C>   |
|-------------------------|-------------------|---------------------------------|
|    List<? extends B>    |    A    B         |             List<B>   List<C>   |
|-------------------------|-------------------|---------------------------------|
|    List<? extends A>    |    A              |   List<A>   List<B>   List<C>   |
|-------------------------|-------------------|---------------------------------|
List<? super T> - writing and assigning:

|-------------------------|-------------------|-------------------------------------------|
|         wildcard        |        add        |                   assign                  |
|-------------------------|-------------------|-------------------------------------------|
|     List<? super C>     |              C    |  List<Object>  List<A>  List<B>  List<C>  |
|-------------------------|-------------------|-------------------------------------------|
|     List<? super B>     |         B    C    |  List<Object>  List<A>  List<B>           |
|-------------------------|-------------------|-------------------------------------------|
|     List<? super A>     |    A    B    C    |  List<Object>  List<A>                    |
|-------------------------|-------------------|-------------------------------------------|


Method References: 
===============

Não é reflaction , é uma maneira de escrever lambda de uma maneira mais enxuta. 
Lambdas que apenas passam um argumento para um método.

```java
palavras.forEach(System.out::println) 

é igual

palavras.forEach(s -> System.out.println(s))
``` 




Stream: 
===============

Toda Collection tem um método stream()

Streams são abstrações, streams não são objetos físicos com dados como Sets, Maps, Lits, Collections...

Stream é um pipeline por onde os dados fluem e são transformados.

Streams tem uma fluente api que podemos encadear  

Tudo que é feito em uma stream não impacta a lista que originou a stream, na coleção original.

A cada etapa da cadeia é devolvido uma Stream do tipo que a invocou, no caso abaixo de Cursos.

```java

public static void main(String[] args) {
		List<Curso> cursos = Arrays.asList(
				new Curso("JavaScript", 150),
				new Curso("Java 8", 113),
				new Curso("Python", 45),
				new Curso("C", 55)
				
				);
cursos.stream() 
			  .filter(c -> c.getAlunos() > 100)
			  .forEach(c -> System.out.println(c.getNome()));
``` 

Streams permitem o trabalho em paralelo.

Stream trabalham em Lazy evaluation, ou seja ao entrar em um pipeline cada elemento passa pelo pipeline completo e não a Collection inteira no primeiro pipeline, depois a collection inteira no segundo pipeline (.filter().map()....) Mas somente se as funções não tiverem side-effects.

Comportamento de Streams:
---------------------

Podemos modificar as Stream no input , ou durante o pipeline

Sized: podem ter tamanho definido ou ter tamanho ilimitado  

Ordered: Tem elementos que seguem uma ordem , primeiro elemento , segundo elemento ...

Distinct: Pode conter elementos duplicados ou não

Sorted : pode estar ordenada ou não

```java
List<Integer> numbers = Arrays.asList(1,2,3,4,5,1,2,3,4,5);
		
		numbers.stream()
			   .filter(e -> e % 2 == 0)
			   .forEach(System.out::println);
			   
		//This stream is sized = came from a finite list 
		//This stream is ordered = List is ordered , first element, second ... index(0), index (1) ...
		//non-distinct = Have duplicates values
		//non-sorted = the values are not sorted


	//Exemple of infinity Stream  = non-sized 
	Stream.itarete(100, e -> e + 1); 100,101,102,103....

```



Optional: 
===============
Permite trabalharmos com referencias sem precisar tratar a todo momento if(ObjetoQualquer = null), fazer tratamentos se estamos recebendo algo nulo.
Então recebemos um Optional<T> que pode receber um Objeto do tipo <T> ou não. 

Ganhamos muito com essa nova introdução. Assim não precisamos escrever aqueles diversos ifs garantindo que o objeto não é nulo, temos uma forma muito mais interessante de representar nossas intenções. A classe Optional nos oferece uma variedade imensa de novos métodos que nos permite trabalhar de forma funcional com nossos valores, tirando maior proveito dos novos recursos de default methods, lambdas e method reference. Você pode ler mais sobre essa API em sua documentação:


Collectors: 
===============

Ao trabalar com uma stream , os alterações nunca serão feitas na Collection original.

 ```java

public static void main(String[] args) {
		List<Curso> cursos = Arrays.asList(
				new Curso("JavaScript", 150),
				new Curso("Java 8", 113),
				new Curso("Python", 45),
				new Curso("C", 55)
				
				);
List<Curso> cursosComMaisDe100Alunos = cursos.stream()
			  .filter(c -> c.getAlunos() >= 100)
			  .collect(Collectors.toList());
``` 

Para alterar a antiga coleção podemos fazer : 

 ```java

public static void main(String[] args) {
		List<Curso> cursos = Arrays.asList(
				new Curso("JavaScript", 150),
				new Curso("Java 8", 113),
				new Curso("Python", 45),
				new Curso("C", 55)
				
				);
cursos = cursos.stream()
			  .filter(c -> c.getAlunos() >= 100)
			  .collect(Collectors.toList());
``` 
