package io.exnihilo.basics.immutable;

import lombok.Getter;

import java.util.HashMap;
import java.util.Iterator;

/**
 * To create immutable class in java, you have to do following steps.
 * <p>
 * Declare the class as final so it can’t be extended.
 * Make all fields private so that direct access is not allowed.
 * Don’t provide setter methods for variables
 * Make all mutable fields final so that it’s value can be assigned only once.
 * Initialize all the fields via a constructor performing deep copy.
 * Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
 */
@Getter
public final class ImmutableClassExample {

    private final int id;
    private final String name;
    private final HashMap<String, String> testMap;

    /**
     * Accessor function for mutable objects
     */
    public HashMap<String, String> getTestMap() {
        //return testMap;
        return (HashMap<String, String>) testMap.clone();
    }

    /**
     * Constructor performing Deep Copy
     *
     * @param i
     * @param n
     * @param hm
     */
    public ImmutableClassExample(int i, String n, HashMap<String, String> hm) {
        System.out.println("Performing Deep Copy for Object initialization");
        this.id = i;
        this.name = n;
        HashMap<String, String> tempMap = new HashMap<String, String>();
        String key;
        Iterator<String> it = hm.keySet().iterator();
        while (it.hasNext()) {
            key = it.next();
            tempMap.put(key, hm.get(key));
        }
        this.testMap = tempMap;
    }


    /**
     * Constructor performing Shallow Copy
     * @param i
     * @param n
     * @param hm
     */
    /**
     public ImmutableClassExample(int i, String n, HashMap<String,String> hm){
     System.out.println("Performing Shallow Copy for Object initialization");
     this.id=i;
     this.name=n;
     this.testMap=hm;
     }
     */

    /**
     * To test the consequences of Shallow Copy and how to avoid it with Deep Copy for creating immutable classes
     *
     * @param args
     */
    public static void main(String[] args) {
        HashMap<String, String> stringHashMap = new HashMap<String, String>();
        stringHashMap.put("1", "first");
        stringHashMap.put("2", "second");
        String stringString = "original";
        int i = 10;

        ImmutableClassExample immutableClassExample = new ImmutableClassExample(i, stringString, stringHashMap);

        //Lets see whether its copy by field or reference
        System.out.println(stringString == immutableClassExample.getName());
        System.out.println(stringHashMap == immutableClassExample.getTestMap());
        //print the immutableClassExample values
        System.out.println("immutableClassExample id:" + immutableClassExample.getId());
        System.out.println("immutableClassExample name:" + immutableClassExample.getName());
        System.out.println("immutableClassExample testMap:" + immutableClassExample.getTestMap());
        //change the local variable values and print again
        i = 20;
        stringString = "modified";
        stringHashMap.put("3", "third");
        System.out.println("immutableClassExample id after local variable change:" + immutableClassExample.getId());
        System.out.println("immutableClassExample name after local variable change:" + immutableClassExample.getName());
        System.out.println("immutableClassExample testMap after local variable change:" + immutableClassExample.getTestMap());

        HashMap<String, String> hmTest = immutableClassExample.getTestMap();
        hmTest.put("4", "new");
        System.out.println("immutableClassExample testMap after changing variable from accessor methods:" + immutableClassExample.getTestMap());
    }
}