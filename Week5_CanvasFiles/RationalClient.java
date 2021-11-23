/* File: RationalClient.java
 *  Author: Andre Berger
 *
 *  Tests several methods for the class Rational.
 */

public class RationalClient {

  public static void main(String[] argv) {


    Rational f1 = new Rational(3, 4);
    Rational f2 = new Rational(12, 20);

    System.out.println("The rational number f1 is " + f1); // toString is implicit
    System.out.println("The rational number f2 is " + f2);

    System.out.println("The floating point value of " + f1 + " is " +
                       f1.toDecimal());
    System.out.println("The floating point value of " + f2 + " is " +
                       f2.toDecimal());
    System.out.println("f1 + f2  = " + (f1.add(f2)) + " =  " +
                       (f1.add(f2)).toDecimal());
    System.out.println("f1 * f2  = " + (f1.times(f2)) + "  = " +
                       (f1.times(f2)).toDecimal());

    System.out.println("1/f1  = " + (f1.reciprocal()) + "  = " +
                       (f1.reciprocal()).toDecimal());

    System.out.println("f1 / f2  = " + (
                                        f1.divide(f2)) + "  = " +
                       (f1.divide(f2)).toDecimal());
  }
}

