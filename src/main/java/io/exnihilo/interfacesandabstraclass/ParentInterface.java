package io.exnihilo.interfacesandabstraclass;

/**
 * Abstract class and interface are used to achieve abstraction through abstract methods.
 * Abstract class and interface both can't be instantiated. But there are many differences
 * between abstract class and interface that are given below.
 * _
 * 1) Abstract class can have abstract and non-abstract methods.
 * Interface can have only abstract methods. Since Java 8, it can have default and static methods also.
 * _
 * 2) Abstract class doesn't support multiple inheritance.
 * Interface supports multiple inheritance.
 * _
 * 3) Abstract class can have final, non-final, static and non-static variables.
 * Interface has only static and final variables.
 * _
 * 4) Abstract class can provide the implementation of interface.
 * Interface can't provide the implementation of abstract class.
 * _
 * 5) The abstract keyword is used to declare abstract class.
 * The interface keyword is used to declare interface.
 * _
 * 6) An abstract class can extend another Java class and implement multiple Java interfaces.
 * An interface can extend another Java interface only.
 * _
 * 7) An abstract class can be extended using keyword "extends".
 * An interface class can be implemented using keyword "implements".
 * _
 * 8) InterfaceA Java abstract class can have class members like private, protected, etc.
 * Members of a Java interface are public by default.
 * _
 * Simply, abstract class achieves partial abstraction (0 to 100%) whereas interface achieves fully abstraction (100%).
 * When to use what?
 * _
 * Consider using abstract classes if any of these statements apply to your situation:
 * In java application, there are some related classes that need to share some lines of code then you can put these lines of code within abstract class and this abstract class should be extended by all these related classes.
 * You can define non-static or non-final field(s) in abstract class, so that via a method you can access and modify the state of Object to which they belong.
 * You can expect that the classes that extend an abstract class have many common methods or fields, or require access modifiers other than public (such as protected and private).
 * _
 * Consider using interfaces if any of these statements apply to your situation:
 * It is total abstraction, All methods declared within an interface must be implemented by the class(es) that implements this interface.
 * A class can implement more than one interface. It is called multiple inheritance.
 * You want to specify the behavior of a particular data type, but not concerned about who implements its behavior.
 */
interface ParentInterface {
    String STRING_CONSTANT_IN_INTERFACE_A = "CONSTANT";//by default: public final

    void parentInterfaceMethod(); //by default, public and abstract

    void b();
}

//Interface can have MULTIPLE INHERITANCE
interface ParentInterfaceExtended extends AutoCloseable, ParentInterface {
    void b();

    void parentInterfaceExtendedMethod();
}

//Abstract class that provides implementation of one method of ParentInterface interface
abstract class ParentAbstractClass implements ParentInterfaceExtended {

    public final String stringInAbstractClass = "AnyString";

    //abstract should be defined in Abstract Class method
    public abstract void abstractClassAMethod();

    @Override //Not necessary
    public void parentInterfaceMethod() {
        System.out.println("I am parentInterfaceMethod: " + STRING_CONSTANT_IN_INTERFACE_A);
    }
}

//Creating abstract class extending abstract class ParentInterface, now we don't provide the implementation.
abstract class ParentAbstractClassExtended extends ParentAbstractClass {

}

//Creating subclass of abstract class, now we need to provide the implementation of rest of the methods  
class InterfaceTestClass extends ParentAbstractClassExtended {

    @Override //Necessary
    public void b() {
        System.out.println("I am b");
    }

    @Override
    public void parentInterfaceExtendedMethod() {
        System.out.println("I am parentInterfaceExtendedMethod: " + STRING_CONSTANT_IN_INTERFACE_A);
    }

    @Override //Necessary
    public void abstractClassAMethod() {
        System.out.println("I am abstractClassAMethod: " + STRING_CONSTANT_IN_INTERFACE_A);
    }

    @Override
    public void close() throws Exception {
    }

    public static void main(String args[]) {
        ParentInterface parentInterface = new InterfaceTestClass();
        System.out.println(((InterfaceTestClass) parentInterface).stringInAbstractClass);
        ((InterfaceTestClass) parentInterface).abstractClassAMethod();
        parentInterface.parentInterfaceMethod();
        ((InterfaceTestClass) parentInterface).parentInterfaceExtendedMethod();

        InterfaceTestClass interfaceTestClass = new InterfaceTestClass();
        interfaceTestClass.b();
        System.out.println(interfaceTestClass.stringInAbstractClass);
    }
}
