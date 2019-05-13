package io.exnihilo.basics;

class FinallyExample {
    public static void main(String args[]) {
        try {

            try {
                int num = 121 / 0;
                System.out.println(num);
            } catch (ArithmeticException e) {
                System.out.println("Number should not be divided by zero");
                //int a = 122/0;
                System.out.println("Hello");
                throw new ArithmeticException("Rethrowing");
            }
            /* Finally block will always execute
             * even if there is no exception in try block
             */ finally {
                Integer b = null;
                Integer num = b / new Integer(0);
                System.out.println("This is finally block");
            }
            System.out.println("Out of try-catch-finally");
        } catch (NullPointerException e) {
            System.out.println("Inside Outer Catch NullPointerException" + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Inside Outer Catch ArithmeticException" + e.getMessage());
        }
    }
}