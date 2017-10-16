package mylambdapackage;

/**
 *
 * Notes -
 *
 * You always think of objects/things/nouns when ever designing some thing in Java. Java v8 attempts to eliminate this
 * and think of actions and verbs.
 *
 * Sample Lambda Expressions -
 *
 * 1. greetingFunction = () -> System.out.println("Hello World !");
 *    Now we can pass 'greetingFunction' to the below function
 *
 * 2. doubleNumberFunction = (int a) -> a * 2;
 *
 * 3. addFunction = (int a, int b) -> a + b;
 *
 * 4. safeDivideFunction = (int a, int b) -> {
 *          if (b == 0) return 0;
 *          return a / b;
 *    }
 *
 * 5. stringLengthCountFunction = (String x) -> {
 *          if (x == null) return 0;
 *          return s.length();
 *    }
 *
 */
public class Greeter {

    public void greet(Greeting greeting) {
        greeting.perform();
    }

    public static void main(String[] args) {

        Greeter greeter = new Greeter();

        // What are we doing here ? We are doing polymorphism here where we are passing a behaviour into the greeter.
        // What is the problem here ? We are not actually only passing a behaviour but rather a thing (class) that has a behaviour.
        // Can we instead pass an action in ? We can do this by Lambdas. These are functions existing in isolation.
        // We make a method a thing and assign it to a variable - Function as a value.
        Greeting helloWorldGreeting = new HelloWorldGreeting();
        greeter.greet(helloWorldGreeting);

        // See Below Lambda expressions. We have 2 of them where each of them needs to have an interface with a method that
        // matches the signature. We can also use the Greeting interface for the myLambdaFunction !!
        // And then pass it to our method. We can easily implement many many versions (lambdas) of this method.
        Greeting myLambdaFunction = () -> System.out.println("Hello World !");
        greeter.greet(myLambdaFunction);

        MyAdd addFunction = (int a, int b) -> a + b;
        int sum = addFunction.add(2, 3);
        System.out.println(sum);

    }

}

interface MyLambda {

    void foo();
}

interface MyAdd {

    int add(int a, int b);
}
