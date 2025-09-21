package JavaStreams.Concepts;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperation {
    public static void main(String[] args) {
        // Intermediate operations are the methods which converts one stream into another stream
        // They are lazy, meaning they don't execute until a terminal operation is invoked

        List<String> list = Arrays.asList("Preeti", "Rushi", "Sham", "Rrr");

        //1. filter() - filters the stream and gove new stream. takes predicate<> interface
       Stream<String> filteredNames =  list.stream().filter(x -> x.startsWith("R"));
       //no filtering happens at this point because intermediate methods are lazy. It happens once terminal methods are called.

        //2. map() - transform a string into another by performing some action on it. takes function <> interface
        Stream<String> stringStream = list.stream().map(x -> x.toUpperCase());
        //System.out.println(stringStream);

        //3. sorted() - gives the sorted stream
        Stream<String> stringSorted = list.stream().sorted();
        Stream<String> stringSorted1 = list.stream().sorted(String::compareTo);
        //System.out.println(stringSorted);
        //System.out.println(stringSorted);

        //4. distinct() - removes duplicates
        Stream<String> stringDistinct = list.stream().filter(x-> x.startsWith("r")).distinct();
        System.out.println(stringDistinct);

        //5. limit()
        System.out.println(Stream.iterate(1, x -> x+1).limit(100).count());
        //6.skip()
        System.out.println( Stream.iterate(1, x -> x+1).limit(100).skip(10).count());

        //7. peek() - mainly used for Debugging or logging in the middle of a pipeline or performing some action on each element
        //it does not transform elements — it returns the same element unchanged.
        Stream.of("one", "two", "three")
                .filter(s -> s.length() > 3)
                .peek(s -> System.out.println("Filtered value: " + s)) // debugging in the middle of pipline
                .map(String::toUpperCase) // transform
                .peek(s -> System.out.println("Mapped value: " + s))   // debug in the middle of pipeline
                .forEach(System.out::println);

        // 8. flatMap() - each element of a stream produces a stream itself, and you want to flatten them into a single stream
         List<String> sentences = Arrays.asList("I love Java", "Streams are powerful");
        System.out.println(sentences.stream().flatMap(x -> Arrays.stream(x.split(" "))).map(String::toUpperCase).toList());

        List<String> sentences2 = Arrays.asList(
                "Hello World",
                "Java stream are powerful",
                "flatmap is useful"
        );
        System.out.println(sentences2.stream()
                .flatMap(x -> Arrays.stream(x.split(" ")))
                .map(String::toUpperCase)
                .toList());

    }
}
