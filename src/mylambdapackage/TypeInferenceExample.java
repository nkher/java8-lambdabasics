package mylambdapackage;

public class TypeInferenceExample {

    interface StringLengthLambda {

        int getLength(String s);
    }

    public static void printLambda(StringLengthLambda s) {
        System.out.println(s.getLength("Hello Lambda"));
    }

    public static void main(String[] args) {

        // Here in the below example we do not need to provide the type information of the input arguments
        // as we do that already when we declare the method in the interface the compiler knows by itself.
        // If only one argument we do not need to give the parentheses
        StringLengthLambda myLambda = s -> s.length();
        System.out.println(myLambda.getLength("Hello Lambda"));

        printLambda(myLambda);
    }

}
