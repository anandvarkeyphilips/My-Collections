package io.exnihilo.aggregation;

/**
 * If a class have an entity reference, it is known as Aggregation.
 * Aggregation represents HAS-A relationship.
 * Code reuse is also best achieved by aggregation when there is no is-a relationship.
 * Inheritance should be used only if the relationship is-a is maintained throughout
 * the lifetime of the objects involved; otherwise, aggregation is the best choice.
 */
class Operation {
    int square(int n) {
        return n * n;
    }
}

class Circle {
    Operation op;//aggregation
    double pi = 3.14;

    double area(int radius) {
        op = new Operation();
        int rsquare = op.square(radius);//code reusability (i.e. delegates the method call).
        return pi * rsquare;
    }


    public static void main(String args[]) {
        Circle c = new Circle();
        double result = c.area(5);
        System.out.println(result);
    }
}  