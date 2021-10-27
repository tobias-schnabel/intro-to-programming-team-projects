/* BMI.java
Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)*/
         
import java.util.Scanner;
import java.lang.Math;

public class BMI {

	public static void main(String[] args) {

   Scanner in = new Scanner(System.in);
   
   System.out.print("Enter a mass in kilograms: ");
      double Mass = in.nextDouble();
      
   System.out.print("Enter height in meters: ");
      double Height = in.nextDouble();
      
      
   double BMI = Mass / (Math.pow(Height, 2));
          //rounding to 2 decimal places
          String BMIRound = String.format("%.1f", BMI);
             
      
    System.out.println("Your body mass index is " + BMIRound);  
    
       //Calculates the min and max weight for the given height according to BMI
       double MinWeight = 18.5 * (Math.pow(Height, 2));
       double MaxWeight = 25 * (Math.pow(Height, 2));
       
       
       
    if (BMI > 25) {double MinWghtLoss = Mass - MaxWeight;
                   double MaxWghtLoss = Mass - MinWeight;
                   
                   System.out.print("You are overweight. You should lose between ");
                   System.out.println(MinWghtLoss + " and " + MaxWghtLoss + " kg ");
                   System.out.print("in order to reach a normal weight");
                   }
                   
    else if (18.5 < BMI && BMI < 25) {System.out.print("You have a normal weight.");
                                      }
                                      
    else {double MinWghtGain = MinWeight - Mass;
          double MaxWghtGain = MaxWeight - Mass;
          
          System.out.print("You are underweight. You should gain between ");
          System.out.println(MinWghtGain + " and " + MaxWghtGain + " kg ");
                   System.out.print("in order to reach a normal weight");
          }
     }
}
