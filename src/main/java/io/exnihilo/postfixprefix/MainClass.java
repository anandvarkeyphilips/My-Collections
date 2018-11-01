package io.exnihilo.postfixprefix;

import io.exnihilo.postfixprefix.packageone.A;

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
        System.out.println(new B().methodOne(101));
    }
}