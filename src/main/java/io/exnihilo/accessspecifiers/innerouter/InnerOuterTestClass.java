package io.exnihilo.accessspecifiers.innerouter;

/**
 * Created by anand on 8/4/2018.
 */
public class InnerOuterTestClass {
    public static void main(String... args) {
        OuterClass outerClass = new OuterClass();
        outerClass.testInnerPrivateAndStaticProtectedClassMethods();

        OuterClass.InnerProtectedClass innerProtectedClass = outerClass.new InnerProtectedClass();
        innerProtectedClass.testOuterClassMethodsFromInnerProtectedClass();
        innerProtectedClass.getInnerDefaultName();
        innerProtectedClass.getInnerPublicName();
        innerProtectedClass.getInnerProtectedName();
        //innerProtectedClass.getInnerPrivateName();

        outerClass.testInnerPrivateAndStaticProtectedClassMethods();
        OuterClass.InnerStaticProtectedClass innerStaticProtectedClass = new OuterClass.InnerStaticProtectedClass();
        innerStaticProtectedClass.getInnerDefaultName();
        innerStaticProtectedClass.getInnerPublicName();
        innerStaticProtectedClass.getInnerProtectedName();
        //innerStaticProtectedClass.getInnerPrivateName();

        System.out.println(innerStaticProtectedClass.innerProtectedName);
        innerStaticProtectedClass.testOuterClassMethodsFromInnerStaticProtectedClass();
        System.out.println(innerStaticProtectedClass.innerProtectedName);

        OuterClass.InnerStaticProtectedClass innerStaticProtectedClassAgain = new OuterClass.InnerStaticProtectedClass();
        System.out.println(innerStaticProtectedClassAgain.innerProtectedName);
    }
}