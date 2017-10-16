package myclosurespackage;

public class ClosureExample {

    public static void doProcess(int i, Process p) {
        p.process(i);
    }

    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        // Similar to concept of closure in which the java compiler uses the value of b
        // by freezing it (makes it a final) and uses it inside the lambda expression of b
        // The compiler expects it to be effectively final. Means you cannot change the
        // value of the variables in the enclosing scope of the lambda
        doProcess(a, (i) -> System.out.println(i + b));
    }

}
