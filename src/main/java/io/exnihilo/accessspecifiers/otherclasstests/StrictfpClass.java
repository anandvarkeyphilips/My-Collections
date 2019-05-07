package io.exnihilo.accessspecifiers.otherclasstests;

strictfp class StrictfpClass {
    // all concrete methods here are
    // implicitly strictfp.
}

strictfp interface StrictfpInterface {
    // all  methods here becomes implicitly
    // strictfp when used during inheritance.

    //strictfp double mul(); // compile-time error here
}

class Car {

    // strictfp applied on a concrete method
    strictfp void calculateSpeed() {
    }
}