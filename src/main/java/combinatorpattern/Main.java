package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Fred",
                "fred@gmail.com",
                "+13203183727",
                LocalDate.of(2000, 1, 1)
        );

        //System.out.println(new CustomerValidatorService().isValid(customer) );

        // If valid we can store costumer in db

        //Using Combinator pattern

        ValidationResult result = isEmailValid()
                .and(isPhoneNolValid())
                .and(isAnAdult())
                .apply(customer);

        System.out.println(result);

        if (result != ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }

    }

}
