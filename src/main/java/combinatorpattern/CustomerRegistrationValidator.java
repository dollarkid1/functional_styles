package combinatorpattern;

import java.security.cert.X509Certificate;
import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

public interface CustomerRegistrationValidator extends Function<Customer, CustomerRegistrationValidator.ValidationResult> {

    static CustomerRegistrationValidator isEmailValid(){
        return
                customer -> customer.getEmail().contains("@") ?
                        SUCCESS : EMAIL_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isPhoneNolValid(){
        return
                customer -> customer.getPhoneNo().contains("+1") ?
                        SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAnAdult(){
        return
                customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ?
                        SUCCESS : IS_NOT_AN_ADULT;
    }


    default CustomerRegistrationValidator and (CustomerRegistrationValidator other){
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }



enum ValidationResult{
    SUCCESS,
    PHONE_NUMBER_NOT_VALID,
    EMAIL_NUMBER_NOT_VALID,
    IS_NOT_AN_ADULT
}
}

