package mylambdapackage;

/**
 * Created by nameshkher on 9/22/17.
 */
public class RunnableExample {

    public static void main(String[] args) {

        // Classic example of an anonymous inner class
        Thread myThread = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Printed inside Runnable.");
            }
        });
        myThread.run();

        // We can create a Lambda of the above code. An example of how java developers kept in mind backward
        // compatibility. Lambdas work with old APIs like Threads.
        Thread myLambdaThread = new Thread( () -> System.out.println("Printed inside Lambda Runnable.") );
        myLambdaThread.run();
    }

}
