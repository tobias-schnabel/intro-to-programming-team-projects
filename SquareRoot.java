
/* DayOfWeek.java
Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)*/

import java.util.Scanner;
import java.lang.Math;

/*
Write a program SquareRoot that takes as input two arguments of type double,
a positive real value a > 0 and a precision value epsilon > 0. The program should
output an approximate value of √ a up to a precision of epsilon using the following algorithm:

1. Set x 0 = a/2 and i = 0

2. Compute a next value x 1 = (x 0 +

a0  x )/2

3. Keep computing the next value x i+1 in the same way until | x i+1 − x i | ≤ epsilon

You can use the Math.abs() method to calculate the absolute value of a number.
 */

public class SquareRoot {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a ");
        double a = in.nextDouble(); //get input
        System.out.print("Enter epsilon ");
        double epsilon = in.nextDouble();

        double xi = a/2; //declare and init first var
        double xiPlusOne = 0; //declare and init 2nd storage var

        while (Math.abs(xiPlusOne-xi) > epsilon ) {
            double xitemp= (xi + (a / xi)) /2;
            xiPlusOne = xi;
            xi = xitemp;
        }
        System.out.print("The approximate value of sqrt(a) is "+xi);
    } //close main
            //temp var holds val xi+1
            //compute xi and xi+1 new vals
            //use temp to assign xi

} //close class
