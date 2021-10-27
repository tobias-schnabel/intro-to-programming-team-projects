import java.util.Scanner;
import java.lang.Math;

public class RightTriangle {

	public static void main(String[] args) {
   
   System.out.println("enter the lengths for a, b and c");
   
      Scanner in = new Scanner(System.in);
      
   System.out.print("a = ");
      int a = in.nextInt();
      
   System.out.print("b = ");
      int b = in.nextInt();

   System.out.print("c = ");
      int c = in.nextInt();


      double AandB = Math.pow(a, 2) + Math.pow(b, 2);
      double AandC = Math.pow(a, 2) + Math.pow(c, 2);
      double BandC = Math.pow(b, 2) + Math.pow(c, 2);
      
      
      //Pythagoras theorem
    if (AandB == Math.pow(c, 2) || AandC == Math.pow(b, 2) || BandC == Math.pow(a, 2)) {
         System.out.print(a + ", " + b + " and " + c + " can be the side lengths of a right triangle"); 
         }
         
    else System.out.print(a + ", " + b + " and " + c + " cannot be the side lengths of a right triangle");  
        
   }
}