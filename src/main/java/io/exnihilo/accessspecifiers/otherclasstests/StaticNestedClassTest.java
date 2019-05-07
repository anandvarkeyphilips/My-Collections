package io.exnihilo.accessspecifiers.otherclasstests;

public class StaticNestedClassTest {

    public static class StaticNestedClass {
        public static String string = "innerStaticClass: Static Variable";

        public static String innerStaticClassMethod() {
            System.out.println("Inside innerStaticClassMethod: " + string);
            return string;
        }
    }

    public static void callInnerStaticClassMethod() {
        System.out.println("Calling InnerStaticClassMethod : Returns" +
                StaticNestedClass.innerStaticClassMethod());
    }

    public static void main(String args[]) {
        StaticNestedClass nested = new StaticNestedClass();
        nested.innerStaticClassMethod();

        StaticNestedClass.innerStaticClassMethod();
    }
}