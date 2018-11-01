package io.exnihilo.postfixprefix;

public class PostfixDoubt {

    public static void main(String[] args) {
        int i = 1;
        i = i++ + m(i);
        System.out.println(i);
    }

    public static int m(int i) {
        System.out.println(i);
        return 0;
    }
}