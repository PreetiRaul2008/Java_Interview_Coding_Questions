package JavaStreams.Concepts;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {
        //Collectors is a utility class
        // provided a set of methods to create common collectors

        //1. Collecting to a List
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        List<String> a = names.stream().filter(x -> x.startsWith("A")).collect(Collectors.toList());
        System.out.println(a);

        //2. Collecting to a Set
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5, 6 ,6, 7, 8, 9, 10);
        Set<Integer> integerSet = numbers.stream().collect(Collectors.toSet());
        System.out.println(integerSet);

        //3. Collecting to a Specific Collection -- we can convert stream into any collection
        ArrayDeque<String> arrayDeque= names.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));

        //4. Joining Strings -- joins Strings using stream
        System.out.println(names.stream().collect(Collectors.joining())); //Without deliminator
        System.out.println(names.stream().collect(Collectors.joining(", "))); //With Deliminator
        System.out.println(names.stream().collect(Collectors.joining(" | ", "[", "]"))); //With Deliminator, prefix and suffix

        // 5. Summarizing data -
        // performing aggregate operations like count, sum, min, max, and average all together
        // gives a summary statistics object (IntSummaryStatistics)
        IntSummaryStatistics collects =  numbers.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Max : "+collects.getMax());
        System.out.println("Min : "+collects.getMin());
        System.out.println("Average : "+collects.getAverage());
        System.out.println("Count : "+collects.getCount());
        System.out.println("Sum : "+collects.getSum());

        Double average = numbers.stream().collect(Collectors.averagingInt(x -> x));
        System.out.println("Average : "+average);

        Long count = numbers.stream().count();
        System.out.println("Count : "+count);

        //8. Grouping elements -- categorize data based on a property
        List<String> words = Arrays.asList("hello", "world", "java", "streams", "collecting");
        System.out.println(words.stream().collect(Collectors.groupingBy(x -> x.length()))); // group by the elements on behalf of length
        System.out.println(words.stream().collect(Collectors.groupingBy(x-> x.length(),Collectors.joining())));
        TreeMap treeMap = words.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.joining()));
        System.out.println(treeMap);

        List<Integer> numList = List.of(1, 2, 3, 4, 5, 6);
        Map<String,List<Integer>> map =  numList.stream().collect(Collectors.groupingBy(x -> (x % 2 == 0) ? "Even" : "Odd"));
        System.out.println(map);

        //Partitioning elements -- elements are divided into two groups based on a predicate (true or false)

        System.out.println(words.stream().collect(Collectors.partitioningBy(x -> x.length() > 5)));

        //Mapping and Collecting
        System.out.println(words.stream().collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.toList())));
    }
}
