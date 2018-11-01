package io.exnihilo.accessspecifiers.innerouter;

/**
 * Created by anand on 8/4/2018.
 */
public class InnerOuterTestClass {
    public static void main(String... args) {

        OuterClass outerClass = new OuterClass();
        outerClass.testInnerPrivateClassMethods();

        OuterClass.InnerProtectedClass innerProtectedClass = outerClass.new InnerProtectedClass();
        innerProtectedClass.testOuterClassMethods();
        innerProtectedClass.getInnerDefaultName();
        innerProtectedClass.getInnerPublicName();
        innerProtectedClass.getInnerProtectedName();
        //innerProtectedClass.getInnerPrivateName();


    }
}
