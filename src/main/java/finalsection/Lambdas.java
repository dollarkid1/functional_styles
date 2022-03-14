package finalsection;

import java.util.Locale;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {

    public static void main(String[] args) {

        Function<String, String> upperCaseName = name ->
        {   //logic
            if (name.isBlank()) throw new IllegalStateException("");
            return name.toUpperCase();
        };

        BiFunction<String, Integer, String> upperCaseName2 =
                (name, age) ->
        {   //logic
            if (name.isBlank()) throw new IllegalStateException("");
            System.out.println(age);
            return name.toUpperCase();
        };

        String s = upperCaseName2.apply("Alex", 20);
        System.out.println(s);

    }
}
