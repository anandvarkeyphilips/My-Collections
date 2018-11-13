package io.exnihilo.inheritance;

class Dog extends Animal {
    int a = 20, b = 21;

    void bark() {
        System.out.println("Dog barking...");
    }

    void eat() {
        System.out.println("Dog eating..." + a + b);
    }

    void eatSuper() {
        super.eat();
    }
}