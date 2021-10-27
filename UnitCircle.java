/*UnitCircle.java
Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807) */
         
import java.util.Scanner;
import java.lang.Math;

public class UnitCircle {

	public static void main(String[] args) {
   
   Scanner in = new Scanner(System.in);
   
      System.out.print("Enter an x-coordinate: ");
         double x = in.nextDouble();
      
      System.out.print("Enter a y-coordinate: ");
         double y = in.nextDouble();
     
   double xySquared = Math.pow(x, 2) + Math.pow(y, 2);
    
     
   if (xySquared < 1) {
      System.out.print("The point (" + x + ", " + y + ") ");
      System.out.print("lies inside the unit circle.");
      }
   else if (xySquared == 1) {
      System.out.print("The point (" + x + ", " + y + ") ");
      System.out.print("lies on the unit circle."); 
      }
   else {System.out.print("The point (" + x + ", " + y + ") ");
        System.out.print("lies outside the unit circle."); 
        }
   }
      
}