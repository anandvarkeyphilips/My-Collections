package io.exnihilo.accessspecifiers.otherclasstests;

abstract class AnonymousInner {
    public abstract void abstractMethod();
}

public class AnonymousClassTest {

    public static void main(String args[]) {
        AnonymousInner inner = new AnonymousInner() {
            public void abstractMethod() {
                System.out.println("This is an example of anonymous inner class");
            }
        };
        inner.abstractMethod();
    }
}