package io.exnihilo.basics.compare;

class ShortCircuitEvaluation {
    /**
     * The single ones will check every parameter, regardless of the values,
     * before checking the values of the parameters.
     * The double ones will first check the left parameter and its value and if true (||) or false (&&)
     * leave the second one untouched.
     * Sound complicated? An easy example should make it clear:
     */
    public static void main(String arg[]) {

        String aString = null;

        if (aString != null & aString.equals("lala")) ;
        //Both parameters are checked before the evaluation is done and a NullPointerException will be thrown for the second parameter.

        if (aString != null && aString.equals("lala")) ;
        //The first parameter is checked and it returns false, so the second paramter won't be checked, because the result is false anyway.

        //The same for OR:

        if (aString == null | !aString.equals("lala")) ;
        //Will raise NullPointerException, too.

        if (aString == null || !aString.equals("lala")) ;
        //The first parameter is checked and it returns true, so the second paramter won't be checked, because the result is true anyway.

        //XOR can't be optimized, because it depends on both parameters.
    }
}