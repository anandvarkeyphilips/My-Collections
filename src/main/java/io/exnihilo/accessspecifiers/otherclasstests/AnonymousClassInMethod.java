package io.exnihilo.accessspecifiers.otherclasstests;

interface Message {
    String greet();
}

public class AnonymousClassInMethod {
    // method which accepts the object of interface Message
    public void displayMessage(Message m) {
        System.out.println(m.greet() + ", This is an example of anonymous inner class as an argument");
    }

    public static void main(String args[]) {
        // Instantiating the class
        AnonymousClassInMethod obj = new AnonymousClassInMethod();

        // Passing an anonymous inner class as an argument
        obj.displayMessage(
                new Message() {
                    public String greet() {
                        return "Hello";
                    }
                }
        );
    }
}