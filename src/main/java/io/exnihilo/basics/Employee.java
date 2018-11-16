package io.exnihilo.basics;

import lombok.Data;

import java.io.*;
import java.lang.reflect.Constructor;

@Data
public class Employee implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    public static int numberOfEmployees;

    private int employeeID;
    private String employeeName;
    private String address;
    private String startingYear;

    public Employee(int id, String name, String addr, String year) {
        employeeID = id;
        employeeName = name;
        setAddress(addr);
        startingYear = year;
        numberOfEmployees++;
    }

    public Employee() {
        this(10000, null, null, null);
    }

    public static void main(String args[]) throws Exception {

        Employee phil, george, copy;
        phil = new Employee();
        System.out.println(phil);
        System.out.println("Number of employees: " + Employee.numberOfEmployees);

        phil = new Employee(10023, "Phil Coulthard", "70 The Pond, Seneca@York", "2002");
        george = new Employee(10089, "George Farr", "678, IBM Toronto Lab", "1980");
        copy = george;

        System.out.println(phil);
        System.out.println(george);
        System.out.println(copy);
        System.out.println("Number of employees: " + Employee.numberOfEmployees);


        Employee emp1 = new Employee();
        Employee emp2_1 = (Employee) Class.forName("io.exnihilo.basics.Employee").newInstance();
        Employee emp2_2 = Employee.class.newInstance();

        Constructor<Employee> employeeConstructor = Employee.class.getConstructor();
        Employee emp3 = employeeConstructor.newInstance();

        Employee emp4 = (Employee) emp3.clone();

        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("emp4.obj"));
        // writing to object
        o.writeObject(emp4);
        o.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("emp4.obj"));
        Employee emp5 = (Employee) in.readObject();
    }
}