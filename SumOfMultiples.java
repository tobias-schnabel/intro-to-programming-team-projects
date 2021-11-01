/* DayOfWeek.java
Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)*/
         
import java.util.Scanner;
import java.lang.Math;

public class SumOfMultiples {

	public static void main(String[] args) {
   
      Scanner in = new Scanner(System.in);
   
   System.out.print("Enter a positive integer number: ");
      int n = in.nextInt();
      
   
   //print output
   System.out.println("The sum of multiples of 3 and 5 that are less than \n or equal to " + n + " is " + compute(n));
      
   } //close main
       
   public static int compute(int n) {
           
      int x = 0; //declare and init return var
   
   /*the following block of code is precise to the wording of the exercise:
   it adds up ALL multiples of 3 and 5, so e.g. 15 is added TWICE
  (multiple of 3 and of 5) */
  //   for (int  y = 1; y <= n; y++) {
//        int multip3 = 3 * y;
//        if (multip3 <= n) {
//          x += multip3;} else {
//          x += 0;}
//       } //close loop
//       
//     for (int  y = 1; y <= n; y++) {
//        int multip5 = 5 * y;
//        if (multip5 <= n) {
//          x += multip5;} else {
//          x += 0;}    
//      } //close loop


/*the following block of code follows the example in the exercise:
   it adds up only UNIQUE multiples of 3 and 5 */
  for (int  y = 1; y <= n; y++) {
       int multip3 = 3 * y;
       int multip5 = 5 * y;
      
          if (multip3 <= n & multip3 % 5 != 0) {
            x += multip3;} //all mutiples of 3 that are not div by 5        
          if (multip5 <= n & multip5 % 3 != 0) {
            x += multip5;} //all mutiples of 5 that are not div by 3
          if (multip3 * multip5 <= n) {
            x +=  multip3 * multip5;} //all products of 3 and 5 (each divisible by 3 AND 5)              
      } //close loop
       
     
      return x;
      
      } //close method      
   
 //close class
 }