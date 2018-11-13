package io.exnihilo.inheritance;


public class SingleInheritance {
    public static void main(String args[]) {
        Animal animal = new Animal();
        animal.talk();
        animal.eat();
        //animal.bark(); not available for A
        System.out.println("-------------------------------------------------------");

        Dog dog = new Dog();
        dog.talk();
        dog.eat();
        dog.eatSuper();
        dog.bark();
        System.out.println("-------------------------------------------------------");

        Animal dogAnimal = new Dog();
        dogAnimal.talk();
        dogAnimal.eat();
        ((Dog) dogAnimal).eat();
        //dogAnimal.bark(); not available for Animal -> Need down-casting like below
        ((Dog) dogAnimal).bark();
        System.out.println("-------------------------------------------------------");

        //java.lang.ClassCastException: io.exnihilo.inheritance.Animal cannot be cast to io.exnihilo.inheritance.Dog
        //Dog dog1 = (Dog) new Animal();
    }
}