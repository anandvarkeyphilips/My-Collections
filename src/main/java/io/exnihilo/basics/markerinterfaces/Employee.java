package io.exnihilo.basics.markerinterfaces;

import lombok.Data;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * (1) a marker interface must be empty, and (2) implementing it is meant to imply some special treatment of the implementing class.
 * Incorrect: JVM or the compiler would treat the objects of that class differently:
 * Correct: it is the code of Java class library that treats these objects as cloneable, serializable, etc.
 * It has nothing to do with the compiler or the JVM.
 * <pre>
 * else if (obj instanceof Serializable) {
 *     writeOrdinaryObject(obj, desc, unshared);
 * } else {
 *     if (extendedDebugInfo) {
 *         throw new NotSerializableException();
 *     }
 * }
 * </pre>
 * instead of instanceOf operator why can't it be writeObject(Serializable) so that there is compile-time type checking.
 * This lets you avoid polluting your code with the name of the marker interface when a "plain Object" is needed.
 * For example, if you make a class that needs to be serializable, and has object members,
 * you would be forced to either do casting or make your objects Serializable at compile time.
 * This is inconvenient, because the interface is devoid of any functionality.
 *
 * @see Employee
 * If annotations had been in the language from the start,
 * it is doubtful that Serializable would have been an interface, it probably would have been an annotation.
 */

@Data
public class Employee implements Cloneable, Serializable {

    /**
     * If a serializable class doesn’t declare a serialVersionUID, the JVM will generate one automatically
     * at run-time. However, it is highly recommended that each class declares its serialVersionUID as
     * the generated one is compiler dependent and thus may result in unexpected InvalidClassExceptions.
     */
    private static final long serialVersionUID = 1L;
    public static int numberOfEmployees;

    private int employeeID;
    private String employeeName;
    private String address;
    private transient String startingYear;

    public Employee(int id, String name, String address, String year) {
        employeeID = id;
        employeeName = name;
        address = address;
        startingYear = year;
        numberOfEmployees++;
    }

    public Employee() {
        this(10000, "nameSetByConstructor", null, null);
    }

    public Employee(String address) {
        this(10000, "nameSetByConstructor", address, null);
    }

    static Object x = "abc";

    static void intex(Serializable x) {
        if (x instanceof Serializable) {
        }
    }

    public static void main(String args[]) throws Exception {
        Employee phil = new Employee();
        System.out.println(phil);
        System.out.println("Number of employees: " + Employee.numberOfEmployees);

        phil = new Employee(10023, "Phil Coulthard", "70 The Pond, Seneca@York", "2002");
        System.out.println(phil);
        Employee george = new Employee(10089, "George Farr", "678, IBM Toronto Lab", "1980");
        System.out.println(george);
        Employee copy = george;
        System.out.println(copy);
        System.out.println("Number of employees: " + Employee.numberOfEmployees);

        //Can only invoke zero argument constructor
        Employee emp2_1 = (Employee) Class.forName("io.exnihilo.basics.markerinterfaces.Employee").newInstance();
        System.out.println("emp2_1: " + emp2_1);

        //Can only invoke zero argument constructor
        Employee emp2_2 = Employee.class.newInstance();
        System.out.println("emp2_2: " + emp2_2);

        Constructor<Employee> employeeConstructor = Employee.class.getConstructor(new Class[]{String.class});
        Employee emp3 = employeeConstructor.newInstance("employeeConstructor");
        System.out.println("emp3: " + emp3);

        Employee emp4 = (Employee) emp3.clone();
        System.out.println("emp4: " + emp4);
        System.out.println("Number of employees: " + Employee.numberOfEmployees);


        emp4.setAddress("WritingToFileData");
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("emp4.obj"));
        o.writeObject(emp4);
        o.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("emp4.obj"));
        Employee emp5 = (Employee) in.readObject();
        System.out.println("emp5: " + emp5);
        System.out.println("Number of employees: " + Employee.numberOfEmployees);

        intex((Serializable) x);
    }
}