package JavaStreams.Concepts;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperation {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> arrayNum = Arrays.asList(100,22,75,20);

        // 1.collect()
        List<Integer> isEvenList = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(isEvenList);

        long count = list.stream().filter(x -> x % 2 == 0).toList().stream().count();
        System.out.println(count);

        //2 forEach()
        list.forEach(System.out::println);

        //3. reduce() : Combines elements into a single result.
        Optional<Integer> optionalInteger = arrayNum.stream().reduce(Integer::sum);
        System.out.println(optionalInteger.get());

        //4 . count()

        //5. anyMatch, allMatch, noneMatch

        boolean b = list.stream().anyMatch(x -> x % 2 == 0);
        System.out.println(b);

        boolean b1 = list.stream().allMatch( x -> x > 0);
        System.out.println(b1);

        boolean b2 = list.stream().noneMatch(x -> x < 0);


        //6. findFirst, findAny
        Optional<Integer> b3 = list.stream().findFirst();
        System.out.println(b3.get());

        Optional<Integer> b4 = list.stream().findAny();
        System.out.println(b4.get());

        // 7. toArray() - collects all elements of the stream into an array
        // Default toArray() - Returns an Object[]
        // If you need String[], you’d have to cast manually using stream.toArray(String[]::new)
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
        Object[] objArr = numbers.toArray();    // Object[] array
        System.out.println(Arrays.toString(objArr));

        // toArray() is terminal → after calling it, the stream is closed so Must create stream again since it’s already consumed
        Integer[] intArr = Stream.of(1, 2, 3, 4, 5).toArray(Integer[]::new);
        System.out.println(Arrays.toString(intArr));

        // 8. min() or max()- Returns the minimum or maximum element of the stream according to a given comparator
        List<Integer> numbers1 = Arrays.asList(5, 8, 1, 9, 2);
        System.out.println(numbers1.stream().min(Integer::compareTo).get());
        System.out.println(numbers1.stream().max(Integer::compareTo).get());

        //9. forEachOrdered() - Whenever we are using parallelStream so that time the order is not same, So to maintain the order we use forEachOrdered
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Using forEach with parallel stream");
        numbers2.parallelStream().forEach(System.out::println);
        System.out.println("Using forEachOrdered with parallel stream");
        numbers2.parallelStream().forEachOrdered(System.out::println);



        //Examples 1 : Filtering and Collecting names
        List<String> names = Arrays.asList("Anna", "Bob", "Charlie", "David");
        List<String> result = names.stream().filter(x -> x.startsWith("A")).collect(Collectors.toList());
        System.out.println(result);
        System.out.println(names.stream().filter(x -> x.length() > 3).collect(Collectors.toList()));

        //Example 2  : Squaring and sorting numbers
        List<Integer> numbers3 = Arrays.asList(5, 2, 9, 1, 6);
        System.out.println(numbers3.stream().map(x -> x * x).sorted().collect(Collectors.toList()));

        //Example 3 : Summing values
        List<Integer> intNumbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(intNumbers.stream().reduce((x, y)  -> x + y ).get());

        //Example 4: Counting Occurrences of any character
        String sentence  = "Hello World";
        System.out.println(sentence.chars().filter(x -> x == 'l').count());

        //Stateful operation
        //Do not depend on any previous element processed.
        //Each element is processed independently.They don’t need to store state between elements.
        //Usually faster and more parallel-friendly.
        List<String> names1 = Arrays.asList("John", "Jane", "Tom");

        names.stream()
                .filter(n -> n.startsWith("J"))  // Stateless
                .map(String::toUpperCase)        // Stateless
                .forEach(System.out::println);

        //Stateless Operation
        // knowledge of other elements in the stream.
        //Must maintain state to process the stream correctly.
        //May need to see the entire stream before producing results.
        // slower and less parallel-efficient.

        List<Integer> num = Arrays.asList(5, 2, 8, 2, 3);
        num.stream()
                .distinct()   // Stateful
                .sorted()     // Stateful
                .forEach(System.out::println);


    }
}
