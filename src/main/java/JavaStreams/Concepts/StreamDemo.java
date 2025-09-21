package JavaStreams.Concepts;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        // Feature in Java 8
        //process the collection (List, Map etc.) in functional and declarative manner
        // Simplify data processing.
        // uses functional programming
        // Improves Readability and Maintainability
        // Enable easy parallelism without using the complexity of Multithreading

        // What is Stream?
        // a sequence of elements which supports functional and declarative programming

        //How to use Stream?
        // Source -> Intermediate Operation -> terminal Operation

        // Q- Print the count of all even numbers
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5);

        //Before stream
        int count = 0;
        for( int num : number){
            if(num % 2 == 0){
                count ++ ;
            }
        }
        System.out.println(count);

        //After stream
        System.out.println(number.stream().filter(x -> x % 2 == 0).count());

        //Creating Stream
        // 1. From Collection
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();

        //2. From Arrays
        String[] names = {"a", "b", "c"};
        Stream<String> namesStrings =Arrays.stream(names);

        //3. Using Stream,of()
        Stream<String> namesStrings1= Stream.of("a", "b", "c");

        //4. Infinite Streams
        //using Stream.iterate which takes two arguments one is the seed meaning the starting point
        // and another is the UnaryOperator<> meaning a function which taked argument and perform an action
        Stream<Integer> numbers = Stream.iterate(0, x-> x+ 1).limit(100);

        //using Stream.generate which takes supplier as a argument. Supplier gives the output but does take any input
        Stream<Integer> numbers1 = Stream.generate(() -> 1); //--> this will create infinite stream which includes 1

    }
}
