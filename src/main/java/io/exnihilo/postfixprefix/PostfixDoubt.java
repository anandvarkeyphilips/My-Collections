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
/**
 * x = x++;
 * is equivalent to
 * int tmp = x;
 * x++;
 * x = tmp;
 * https://stackoverflow.com/questions/7911776/what-is-x-after-x-x
 **/