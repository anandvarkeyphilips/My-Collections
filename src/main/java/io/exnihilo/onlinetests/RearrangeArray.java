package io.exnihilo.onlinetests;

import java.util.Scanner;

class RearrangeArray {

    public static void main(String[] args) {
        int counter = 0;
        Scanner s = new Scanner(System.in);
        int testCase = s.nextInt();
        int size, rep;
        int[] array1 = null;
        int[] array2 = null;
        int count = 0;
        while (counter < testCase) {

            size = s.nextInt();// Reading input from STDIN
            array1 = new int[size];
            array2 = new int[size];

            for (int i = 0; i < size; i++) {
                //read input
                array1[i] = s.nextInt();
            }

            rep = s.nextInt();
            int j = 0;
            for (int i = 0; i < size; i++) {
                if (array1[i] == rep) {
                    count++;

                } else {
                    array2[j] = array1[i];
                    j++;
                }

            }
            int k, t = 0;
            if (count > 0) {
                for (k = 0; k < count; k++) {
                    array1[k] = 1;

                }
                while (k < size) {
                    array1[k] = array2[t];
                    t++;
                    k++;
                }
            }
            for (int i = 0; i < size; i++)
                System.out.print(array1[i] + " ");
            counter++;
        }
    }
}
