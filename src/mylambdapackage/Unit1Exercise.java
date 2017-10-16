package mylambdapackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by nameshkher on 9/23/17.
 */
public class Unit1Exercise {

    private static void printConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {

        for (Person p : people) {
            if (predicate.test(p)) {
                consumer.accept(p);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
            new Person("Charles", "Dickens", 60),
            new Person("Lewis", "Carroll", 42),
            new Person("Thomas", "Carlyle", 51),
            new Person("Charlotte", "Bronte", 45),
            new Person("Matthew", "Arnold", 39)
        );

        // Step 1: Sort list by last name
        Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

        // Step 2: Create a method prints all elements in the list

        // We changed the method to accept two lambda functions.
        // 1st One is a condition that is using the in built Predicate Functional Interface.
        // 2nd One is a behavour that is using the in built Consumer Functional Interface.
        printConditionally(people, p -> true, p -> System.out.println(p));

        // Step 3: Create a method that prints all people that have last name beginning with C

        System.out.println("----- Printing people having their last names start with C -----\n");
        printConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p));

        System.out.println("----- Printing people having their first names start with C -----\n");
        printConditionally(people, p -> p.getFirstName().startsWith("C"), p -> System.out.println(p));

    }
}




