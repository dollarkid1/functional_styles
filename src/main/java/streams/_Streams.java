package streams;



import java.util.List;
import java.util.stream.Collectors;

import static streams._Streams.Gender.*;


public class _Streams {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Fred", MALE),
                new Person("Lee", MALE),
                new Person("May", FEMALE),
                new Person("Aisha",FEMALE),
                new Person("Abi", FEMALE),
                new Person("Bob", BINARY)
        );


        people.stream()
                .map(person -> person.name)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println();

        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        System.out.println();

        boolean containsOnly =
        people.stream()
                .anyMatch(person  -> FEMALE.equals(person.gender));
        System.out.println(containsOnly);
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

    enum Gender{
        MALE,
        FEMALE,
        BINARY
    }

}
