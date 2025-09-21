package JavaStreams.Concepts;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamDemo {
    // A type of stream that enables parallel processing of elements
    // splits its elements into multiple chunks and processes them in parallel on multiple threads
    // Allowing multiple threads to process parts of the stream simultaneously
    // This can significantly improve performance for large data sets
    // Workload is distributed across multiple threads
    // parallel streams are most effective for CPU intensive or large datasets where tasks are INDEPENDENT
    // they may add overhead for simple tasks or small datasets

    public  static int factorial (int n ) {
        int result = 1;
        for (int i = 2; i < n; i++) {
            result = result * i;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println("-------------Example 1 -----------");

        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate( 1, x -> x + 1).limit(20000).toList();
        List<Long> factorailList = list.stream().map(x -> (long) factorial(x)).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by sequential stream : "+ (endTime - startTime));


        startTime = System.currentTimeMillis();
        list = Stream.iterate( 1, x -> x + 1).limit(20000).toList();
        factorailList = list.parallelStream().map(x -> (long) factorial(x)).toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by parallel stream : "+ (endTime - startTime));

        // Example 2:
        System.out.println("-------------Example 2 -----------");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream().forEach(i -> System.out.println("Using sequential stream : "+Thread.currentThread().getName() + " : " + i));
        numbers.parallelStream().forEach(n -> System.out.println("Using parallel stream : "+Thread.currentThread().getName() + " : " + n));
    }
    /*Parallel streams internally use the ForkJoin framework:
    -The stream splits data into sub-tasks.
    -Each sub-task is submitted to the common ForkJoinPool.
    -Threads (worker-1, worker-2, …) pick up tasks.
    -If a worker finishes early, it can “steal” work from another worker’s queue.
    -The main thread may also participate if idle.*/

}
