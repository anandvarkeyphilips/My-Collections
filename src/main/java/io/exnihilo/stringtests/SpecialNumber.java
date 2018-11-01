package io.exnihilo.stringtests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by anand on 7/21/2018.
 */
public class SpecialNumber {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(Integer.toBinaryString(n));
        String num = Integer.toBinaryString(n);
        if (conditionA(num) || conditionB(num) || conditionC(num)) {
            System.out.println(n + " is special");
        } else
            System.out.println(n + " is not special");
    }

    public static boolean conditionA(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == ('0'))
                return false;
        }
        return true;
    }

    public static boolean conditionB(String num) {
        for (int i = 0; i < num.length(); i++) {
            if ((i % 2 == 0) && (num.charAt(i) == ('0')))
                return false;
            else if ((i % 2 == 1) && (num.charAt(i) == ('1')))
                return false;
        }
        return true;

    }

    public static boolean conditionC(String num) {
        String tokens[] = num.split("0");
        int count = tokens[0].length();
        if (tokens.length > 1)
            for (int i = 1; i < tokens.length; i++) {
                if (tokens[i].length() > 0 && tokens[i].length() != ++count)
                    return false;
            }
        return true;
    }
}
