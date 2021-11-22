/* File: Rational.java
 *  Author:    Andre Berger
 *
 *  Implements several methods for the class Rational.
 */

public class Rational {

   // private variables within an instance of Fraction
   private int numerator;
   private int denominator;

   // Constructs a rational n/d.
   public Rational(int n, int d) {
      this.numerator = n;
      this.denominator = d;
   }

   // Returns the numerator of this rational
   public int getNumerator(){
      return this.numerator;
   }

   // Returns the denominator of this rational
   public int getDenominator(){
      return this.denominator;
   }

   //  returns the double floating point value of this rational number
   public double toDecimal(){
      return (double) this.numerator/this.denominator;
   }

   // add rational f2 to this rational and return the result.
   public Rational add (Rational f2) {
      Rational sum = new Rational(numerator, denominator);
      sum.numerator = this.numerator + f2.numerator;
      sum.denominator = this.denominator + f2.denominator;
      return sum;

   }

   // multiply this Rational by Rational f2 and return the result
   public Rational times (Rational f2) {
      Rational timesF2 = new Rational(numerator, denominator);
      timesF2.numerator = this.numerator * f2.numerator;
      timesF2.denominator = this.denominator * f2.denominator;
      return timesF2;
   }

   // compute the reciprocal of this Rational and return the result
   public Rational reciprocal() {
      Rational reciprocal = new Rational(numerator, denominator);
      reciprocal.numerator = this.denominator;
      reciprocal.denominator = this.numerator;
      return reciprocal;
   }

   // divide this Rational by Rational f2  and return the result
   public Rational divide (Rational f2) {
      Rational divideF2 = new Rational(numerator, denominator);
      divideF2.numerator = this.numerator / this.denominator;
      divideF2.denominator = f2.numerator / f2.denominator;
      return divideF2;

   }

   // Converts this Rational to a string format: "numerator/denominator."
   public String toString()   {
      int gcdivisor = gcd(this.numerator, this.denominator) ;
      return ((this.numerator/gcdivisor) + "/" + (this.denominator/gcdivisor));
   }

   public static int gcd(int n, int m){
       
      while (n%m !=0)
      {
         int a = m;
         m = n % m;
         n = a;
      }

      return m;
   }

}