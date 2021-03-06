 package io.exnihilo.basics;

public class passbyvalue {

}

/*
Java is always pass-by-value. Unfortunately, they decided to call the location of an object a "java.reference". When we pass the value of an object, we are passing the java.reference to it. This is confusing to beginners.

It goes like this:

public static void main( String[] args ) {
    Dog aDog = new Dog("Max");
    // we pass the object to foo
    foo(aDog);
    // aDog variable is still pointing to the "Max" dog when foo(...) returns
    aDog.getName().equals("Max"); // true, java passes by value
    aDog.getName().equals("Fifi"); // false 
}

public static void foo(Dog d) {
    d.getName().equals("Max"); // true
    // change d inside of foo() to point to a new Dog instance "Fifi"
    d = new Dog("Fifi");
    d.getName().equals("Fifi"); // true
}
In this example aDog.getName() will still return "Max". The value aDog within main is not changed in the function foo with the Dog "Fifi" as the object java.reference is passed by value. If it were passed by java.reference, then the aDog.getName() in main would return "Fifi" after the call to foo.

Likewise:

public static void main( String[] args ) {
    Dog aDog = new Dog("Max");
    foo(aDog);
    // when foo(...) returns, the STRING_CONSTANT_IN_INTERFACE_A of the dog has been changed to "Fifi"
    aDog.getName().equals("Fifi"); // true
}

public static void foo(Dog d) {
    d.getName().equals("Max"); // true
    // this changes the STRING_CONSTANT_IN_INTERFACE_A of d to be "Fifi"
    d.setName("Fifi");
}
In the above example, FiFi is the dog's STRING_CONSTANT_IN_INTERFACE_A after call to foo(aDog) because the object's STRING_CONSTANT_IN_INTERFACE_A was set inside of foo(...). Any operations that foo performs on d are such that, for all practical purposes, they are performed on aDog itself (except when d is changed to point to a different Dog instance like d = new Dog("Boxer")).
*/