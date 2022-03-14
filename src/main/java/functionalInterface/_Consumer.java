package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
            Customer lee = new Customer("Lee", "9282");

        System.out.println();
            greetCustomerConsumer.accept(lee);

        System.out.println();
            greetCustomerConsumerV2.accept(lee,false);



    }

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNo) ->
            System.out.println("Hello "+ customer.customerName +
                    ", thanks for registering your phone no. " +
                    (showPhoneNo ? customer.customerPhoneNo : "***"));


    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello "+ customer.customerName +
                    ", thanks for registering your phone no. " +
                    customer.customerPhoneNo);


    static void greetCustomer(Customer customer){
        System.out.println("Hello "+ customer.customerName +
                ", thanks for registering your phone no.");
    }

    static  class  Customer{
        private final String customerName;
        private final String customerPhoneNo;

        Customer(String customerName, String customerPhoneNo) {
            this.customerName = customerName;
            this.customerPhoneNo = customerPhoneNo;
        }
    }
}
