package mymethodreferencesandcollections;

public class MethodReferenceExample1 {

    public static void main(String args[]) {

        // This is a method reference expression and is equivalent to a Lambda expression
        // MethodReferenceExample1::printMessage === () -> printMessage()
        Thread t = new Thread(MethodReferenceExample1::printMessage);
        t.start();
    }

    public static void printMessage() {
        System.out.println("Hello");
    }

}
