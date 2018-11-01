package io.exnihilo.stringtests;

import java.io.Serializable;

final class SingletonClass implements Serializable {

    private static final long serialVersionUID = 1L;

    private static class FooLoader {
        private static final SingletonClass INSTANCE = new SingletonClass();
    }

    private SingletonClass() {
        if (FooLoader.INSTANCE != null) {
            throw new IllegalStateException("Already instantiated");
        }
    }

    public static SingletonClass getInstance() {
        return FooLoader.INSTANCE;
    }

    @SuppressWarnings("unused")
    private SingletonClass readResolve() {
        return FooLoader.INSTANCE;
    }
}
public class SingletonTestClass {
    public static void main(String[] args) {
        SingletonClass.getInstance();

    }
}