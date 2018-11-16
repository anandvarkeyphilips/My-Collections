package io.exnihilo.equalshashcode;

import java.util.Objects;

class Complex {

    private double re, im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public boolean equals(Object o) {
        return Objects.equals(o,this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }

    public boolean equals1(Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Complex)) {
            return false;
        }
        // typecast o to Complex so that we can compare data members
        Complex c = (Complex) o;
        return Double.compare(re, c.re) == 0 && Double.compare(im, c.im) == 0;
    }

    public int hashCode1() {
        int hash = 3;
        hash = 53 * hash + (this.im != 0 ? new Double(this.im).intValue() : 0);
        hash = 53 * hash + (this.re != 0 ? new Double(this.re).intValue() : 0);
        return hash;
    }

    public static void main(String[] args) {
        Complex c1 = new Complex(10, 15);
        Complex c2 = new Complex(10, 15);
        if (c1.equals(c2)) {
            System.out.println("Equal ");
        } else {
            System.out.println("Not Equal ");
        }
    }
}