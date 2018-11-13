package io.exnihilo.postfixprefix;

class A {
    private int methodOne(int i) {
        return ++i;
    }

    public int methodTwo(int i) {
        return methodOne(++i);
    }
}

class B extends A {

    int methodOne(int i) {
        System.out.println(i);
        int data = methodTwo(i++);
        System.out.println(i);
        System.out.println(data);
        return data;
    }
}

public class MainClass {
    public static void main(String[] args) {
        new B().methodOne(101);
    }
}