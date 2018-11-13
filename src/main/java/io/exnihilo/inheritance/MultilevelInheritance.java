package io.exnihilo.inheritance;


public class MultilevelInheritance {
    public static void main(String args[]) {
        BabyDog babyDog = new BabyDog();
        babyDog.weep();
        babyDog.talk();
        babyDog.bark();
        babyDog.eat();
        babyDog.eatSuper();

        System.out.println("-------------------------------------------------------");
        Animal animal = new BabyDog();
        animal.eat();
        ((BabyDog) animal).eatSuper();
        ((BabyDog) animal).weep();


        System.out.println("-------------------------------------------------------");
        Dog dog = new BabyDog();
        dog.eat();
        ((Dog) dog).eat();
    }
}