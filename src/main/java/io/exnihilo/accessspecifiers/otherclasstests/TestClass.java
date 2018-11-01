package io.exnihilo.accessspecifiers.otherclasstests;

/**
 * Created by anand on 8/4/2018.
 */
public class TestClass {


    public static void main(String... args) {
        MultipleClassInSameFile1 multipleClassInSameFile1 = new MultipleClassInSameFile1();
        multipleClassInSameFile1.methodInMultipleClassInSameFile1();
        MultipleClassInSameFile2 multipleClassInSameFile2 = new MultipleClassInSameFile2();
        multipleClassInSameFile2.methodInMultipleClassInSameFile2();

        StaticNestedClassTest.callInnerStaticClassMethod();

        StaticNestedClassTest.StaticNestedClass.innerStaticClassMethod();
    }
}
