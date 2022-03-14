package finalsection;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        hello("lee", null, value ->{
            System.out.println("no lastname provided for " + value);
        });

        hello2("lee", null, () ->{
            System.out.println("no lastname provided for " );
        });
    }

    static void hello(String firstName, String lastname, Consumer<String> callback){
        System.out.println(firstName);
        if (lastname != null) System.out.println(lastname);
        else callback.accept(lastname);
    }

    static void hello2(String firstName, String lastname, Runnable callback){
        System.out.println(firstName);
        if (lastname != null){ System.out.println(lastname);}
        else{ callback.run();}
    }
}
