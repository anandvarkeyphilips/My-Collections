package io.exnihilo.shallowanddeepcopy;


import java.util.Arrays;

/**
 * Whenever we use default implementation of clone method we get shallow copy of object means it creates new instance
 * and copies all the field of object to that new instance and returns it as object type, we need to explicitly cast
 * it back to our original object. This is shallow copy of the object.
 * clone() method of the object class support shallow copy of the object.
 * <p>
 * If the object contains primitive as well as nonprimitive or reference type variable in shallow copy, cloned object
 * cloned object also refers to the same object to which the original object refers as only the object references gets
 * copied and not the referred objects themselves. That’s why the name shallow copy or shallow cloning in Java.
 * If only primitive type fields or Immutable objects are there then there is no difference between shallow and deep copy in Java.
 */

// Code explaining deep copy
class ExDeepCopy {

    private int[] data;

    // altered to make a deep copy of values
    public ExDeepCopy(int[] values) {
        data = new int[values.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = values[i];
        }
    }

    public void showData() {
        System.out.println(Arrays.toString(data));
    }

    public static void main(String[] args) {
        int[] vals = {3, 7, 9};
        ExDeepCopy e = new ExDeepCopy(vals);
        e.showData(); // prints out [3, 7, 9]
        vals[0] = 13;
        e.showData(); // prints out [3, 7, 9]

        // changes in array values will not be
        // shown in data values.
    }
}