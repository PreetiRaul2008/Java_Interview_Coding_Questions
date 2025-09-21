package JavaStreams.Concepts;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

@FunctionalInterface
interface MathOperation{
    public abstract int operate (int a , int b);
}

public class FunctionInterfacesDemo  {
    String name;
    public FunctionInterfacesDemo(String name) {
        this.name = name;
    }

    public static void main(String[] args){
        //------Custom Function Interface--------//
        MathOperation sumOperation = (a, b) -> a + b;
        int res = sumOperation.operate(2, 3);
        System.out.println(res);

        //------- Predefined Functional Interfaces-------//
        //Predicate --> holds a condition
        Predicate<Integer> isEven = x -> x % 2 == 0 ;
        System.out.println(isEven.test(100));

        Predicate<String> startsWithP = x -> x.toLowerCase().startsWith("p") ;
        System.out.println(startsWithP.test("Preeti"));

        Predicate<String> endsWithP = x -> x.toLowerCase().endsWith("i") ;
        System.out.println(endsWithP.test("Preeti"));
        Predicate<String> result = startsWithP.and(endsWithP);
        System.out.println(result.test("Preeti"));

        // Function --> Takes an argument and performs an action on it
        Function <Integer , Integer> doubleIt = x -> x * 2 ;
        System.out.println(doubleIt.apply(100));
        Function <Integer , Integer> triple = x -> x * 3 ;
        System.out.println(triple.apply(100));
        Function <Integer, Integer> result1 = doubleIt.andThen(triple);
        System.out.println(result1.apply(4));
        Function <Integer, Integer> result2 = doubleIt.compose(triple);
        System.out.println(result2.apply(4));
        Function <Integer, Integer> result3 = Function.identity(); // --> returns the value which is already passed
        result3.apply(3);


        //Consumer --> Takes one input, returns nothing (void).Used when you just want to perform an action.
        Consumer<Integer> consumer = x -> System.out.println(x);
        consumer.accept(25);

        List<Integer> numList = Arrays.asList(1,2,3,4,5);
        Consumer<List<Integer>> list = x -> {
            for(int i : x){
                System.out.println(i);
            }
        };
        list.accept(numList);

        // Supplier ---> Takes no input, returns a result.
        Supplier<String> givesHelloWorld = () -> "Hello world";
        System.out.println(givesHelloWorld.get());

        // --- Combined Example ---//
        Predicate<Integer> predicate = x -> x % 2 == 0 ;
        Function<Integer, Integer> function = x -> x * x;
        Consumer<Integer> consumers = x -> System.out.print(x);
        Supplier<Integer> supplier = () -> 100;

        if(predicate.test(supplier.get())){
           consumers.accept(function.apply(supplier.get()));
        }

        //---BiPredicate , BiConsumer , BiFunction -- takes two arguments--//

        BiPredicate<Integer ,Integer> isSumEven = (x,y) -> (x+y) % 2 == 0;
        isSumEven.test(5,5);

        BiConsumer<Integer , Integer> prints = (x,y) -> {
            System.out.println(x);
            System.out.println(y);
        };
        prints.accept(10,20);

        BiFunction<String, String, Integer> biFunction = (x,y) -> (x + y).length();
        System.out.println(biFunction.apply("abc", "rd"));

        //UnaryOperator -->Sometimes the arguments which are passed are of same datatypes.So to reduce that these interfaces are used
        UnaryOperator <Integer> a = x -> x * 2 ;
        System.out.println(a.apply(100));

        //BinaryOperator---> Works same as BiFunction but the only diff is the dataypes of argument we can pass only a single argument
        BinaryOperator <Integer> b = (x ,y) -> (x + y) * 2 ;

        System.out.println(b.apply(100, 200));

        //MethodReference  --> use method without invoking the method like we do in func(x) where x is the parameter.
        // And places that in the place of lamda expression.
        //When the lambda only calls an existing method (no extra logic needed).
        Consumer<Integer> consumer1 = System.out::println;
        consumer1.accept(2500);

        //ConstructorReference --> When the lambda only creates a new object.
        //Custom class
        Function<String, FunctionInterfacesDemo> demoStreamPractice = FunctionInterfacesDemo::new;
        FunctionInterfacesDemo d = demoStreamPractice.apply("Preeti");
        System.out.println(d.name);

        //No-args Constructor
        Supplier<StringBuilder> sb = StringBuilder::new;
        // Equivalent lambda: () -> new StringBuilder()
        System.out.println(sb.get().append("Hello Constructor Reference!"));

        Function<String, String> toString = String::new;
        // Equivalent lambda: s -> new String(s)
        System.out.println(toString.apply("123")); // 123
    }

}