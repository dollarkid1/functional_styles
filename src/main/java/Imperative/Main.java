package Imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static Imperative.Main.Gender.*;

public class Main {

    public static void main(String[] args) {

        List <Person> people = List.of(
            new Person("May", FEMALE),
            new Person("Fred", MALE),
            new Person("Lee",MALE),
            new Person("Aisha",FEMALE),
            new Person("Abi", FEMALE)
        );

        //Imperative approach
        System.out.println("Imperative approach");
        List <Person> females = new ArrayList<>();
        for (Person person : people){
            if (FEMALE.equals(person.gender)){
                females.add(person);
            }
        }

        for (Person female: females){
            System.out.println(female);
        }


        //Declarative approach
        System.out.println("Declarative approach");
        people.stream()
                .filter(person -> FEMALE.equals(person.gender))
//                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("---------------------");
        System.out.println("---------------------");

        List<Person> females2 = people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .collect(Collectors.toList());
        females2.forEach(System.out::println);


        System.out.println("---------------------");
        System.out.println("---------------------");

        //Predicate
        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);

//        List<Person> females3 = people.stream()
//                .filter(personPredicate)
//                .collect(Collectors.toList());
//        females2.forEach(System.out::println);
    }


    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    static enum Gender{
        MALE,FEMALE
    }

}
