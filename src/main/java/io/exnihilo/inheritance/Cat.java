package io.exnihilo.inheritance;

class Cat extends Animal {
    int a = 30, b = 31;

    void eat() {
        System.out.println("Cat eating..." + a + b);
    }

    void meow() {
        System.out.println("Cat meowing...");
    }
}