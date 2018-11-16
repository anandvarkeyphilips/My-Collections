package io.exnihilo.shallowanddeepcopy;


import java.util.Arrays;

//code illustrating shallow copy
class ExShallowCopy {

    private int[] data;

    // makes a shallow copy of values
    public ExShallowCopy(int[] values) {
        data = values;
    }

    public void showData() {
        System.out.println(Arrays.toString(data));
    }

    public static void main(String[] args) {
        int[] vals = {3, 7, 9};
        ExShallowCopy e = new ExShallowCopy(vals);
        e.showData(); // prints out [3, 7, 9]
        vals[0] = 13;
        e.showData(); // prints out [13, 7, 9]

        // Very confusing, because we didn't
        // intentionally change anything about
        // the object e refers to.
    }
}