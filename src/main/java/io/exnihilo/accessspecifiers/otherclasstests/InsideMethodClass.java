package io.exnihilo.accessspecifiers.otherclasstests;

public class InsideMethodClass {

    String defaultName= "defaultName";

    void methodWithClass() {
        /**
         * FINAL should be specified to access local variables
         */
        final int num = 23;

        /**
         * Class within a method and this will be a local type. Like local variables,
         * the scope of the inner class is restricted within the method.
         */
        class MethodInner_Demo {
            public void print() {
                System.out.println("This is method inner class " + num +defaultName);
            }
        } // end of inner class

        // Accessing the inner class
        MethodInner_Demo inner = new MethodInner_Demo();
        inner.print();
    }

    public static void main(String args[]) {
        InsideMethodClass outer = new InsideMethodClass();
        outer.methodWithClass();
    }
}