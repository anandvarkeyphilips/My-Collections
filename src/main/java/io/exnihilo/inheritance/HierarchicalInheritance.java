package io.exnihilo.inheritance;

class HierarchicalInheritance {
    public static void main(String args[]) {
        Cat c = new Cat();
        c.meow();
        c.eat();
        //c.bark();Compile Time Error
    }
}