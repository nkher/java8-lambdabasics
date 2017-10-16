package mymethodreferencesandcollections;

import mylambdapackage.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample2 {

    private static void printConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {

        for (Person p : people) {
            if (predicate.test(p)) {
                consumer.accept(p);
            }
        }
        System.out.println();
    }

    public static void printPerson(Person p) {
        System.out.println(p);
    }

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

        // out in the System out ... is not a static method. It is an instance.
        // We are calling println on the 'out' instance.
        // How does the 3rd argument here know that an input argument is required ?
        // The MethodReference here is taking the place of a Consumer then it knows
        // that there is some parameter required as input
        printConditionally(people, p -> true, System.out::println);

    }

}
