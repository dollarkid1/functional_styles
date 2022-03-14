package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

    private boolean isEmailValid(String email){
        return email.contains("@");
    }

    private boolean isPhoneNoValid(String phoneNo){
        return phoneNo.startsWith("+1");
    }

    private boolean isAdult(LocalDate dob){
        return Period.between(dob, LocalDate.now()).getYears() > 16;
    }

    public boolean isValid(Customer customer){
        return isEmailValid(customer.getEmail())
        && isPhoneNoValid(customer.getPhoneNo())
        && isAdult(customer.getDob());
    }

    public boolean isValidPhone(Customer customer){
        return isEmailValid(customer.getEmail())
        && isPhoneNoValid(customer.getPhoneNo());
    }
}
