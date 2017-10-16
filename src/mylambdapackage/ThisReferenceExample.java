package mylambdapackage;

import myclosurespackage.Process;

public class ThisReferenceExample {

    public void doProcess(int i, Process p) {
        p.process(i);
    }

    public void execute() {
        doProcess(10, (i) -> {

            System.out.println("Value of i is " + i);
            System.out.println(this); // This will point to the ThisReferenceExample class.
        });
    }

    public static void main(String[] args) {

        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
        thisReferenceExample.doProcess(10, new Process() {

            @Override
            public void process(int i) {
                System.out.println("Value of i is " + i);
                System.out.println(this); // this refers to the new Process that is created
            }

            @Override
            public String toString() {
                return "This is the anonymous inner class.";
            }

        });

        // Doing the same with a Lambda
        thisReferenceExample.doProcess(10, (i) -> {

            System.out.println("Value of i is " + i);

            // An instance of a Lambda never touches the 'this' reference. This is by design.
            // If we write a lambda expression within a non static method inside a class it
            // not throw a compiler error. The Lambda however will never modify the 'this'
            // reference. In this case the 'this' reference will point to the class in which
            // the method is defined.
            // System.out.println(this); // Throws a compiler error saying cannot use inside a static context
        });

        thisReferenceExample.execute();
    }

    @Override
    public String toString() {
        return "This is the main ThisReferenceExample class instance.";
    }

}
