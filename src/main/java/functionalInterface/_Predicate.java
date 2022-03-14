package functionalInterface;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

        System.out.println(isPhoneNoValid("070000099000"));
        System.out.println(isPhoneNoValid("09000000000"));

        System.out.println(isPhoneNoValidPredicate.test("07000000000"));
        System.out.println(isPhoneNoValidPredicate.and(contains3).test("07000030000"));
        System.out.println(isPhoneNoValidPredicate.or(contains3).test("09  000030000"));

    }

    static Predicate<String> isPhoneNoValidPredicate = phoneNo ->
            phoneNo.startsWith("07") && phoneNo.length() == 11;

    static Predicate<String> contains3 = phoneNo ->
            phoneNo.contains("3");

    static boolean isPhoneNoValid(String phoneNo){
        return phoneNo.startsWith("07") && phoneNo.length() == 11;
    }
}
