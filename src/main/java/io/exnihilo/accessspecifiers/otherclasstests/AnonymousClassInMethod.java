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

        Message inner = new Message() {
            public String greet() {
                return "This is a normal Anonymous Class";
            }
        };
        obj.displayMessage(inner);
        // Passing an anonymous inner class as an argument
        obj.displayMessage(
                new Message() {
                    public String greet() {
                        return "Hello";
                    }
                }
        );
        obj.displayMessage(() -> {
            System.out.println("inside Hello 1");
            return "Hello 1";
        });
        obj.displayMessage(() -> "Hello 2");
    }
}