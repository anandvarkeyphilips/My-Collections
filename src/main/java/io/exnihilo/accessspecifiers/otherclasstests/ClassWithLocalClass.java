package io.exnihilo.accessspecifiers.otherclasstests;

public class ClassWithLocalClass {

    String defaultName = "defaultName";

    void methodWithClass() {
        //FINAL should be specified to access local variables
        final int num = 23;

        /**
         * Class within a method and this will be a local type. Like local variables,
         * the scope of the inner class is restricted within the method.
         * They cannot have access modifiers in their declaration
         * They have access to both static and non-static members in the enclosing context
         * They can only define instance members
         */
        class MethodInner_Demo {
            //static  int a =1; not possible
            public void print() {
                System.out.println("This is method inner class " + num + defaultName);
            }
        } // end of inner class
        // Accessing the inner class
        MethodInner_Demo inner = new MethodInner_Demo();
        inner.print();
    }

    public static void main(String args[]) {
        ClassWithLocalClass classWithLocalClass = new ClassWithLocalClass();
        classWithLocalClass.methodWithClass();
    }
}