/*DistanceConversion.java
Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807) */
         
import java.util.Scanner;

public class DistanceConversion {

	public static void main(String[] args) {
   
   Scanner in = new Scanner(System.in);
   
      System.out.print("Enter a distance measured in millimeters: ");
         int Dist = in.nextInt();
         
         int Kilometers = Dist / 1000000;
         int RemKilometers = Dist % 1000000;
      
         int Meters = RemKilometers / 1000;
         int RemMeters = RemKilometers % 1000;
      
         int Centimeters = RemMeters / 10;
         int Millimeters = RemMeters % 10;
      
      System.out.print(Dist + " millimeters is equal to " + Kilometers + " kilometers, ");
      System.out.print(Meters + " meters, " + Centimeters + " centimeters and ");
      System.out.print(Millimeters + " millimeters.");
      
      }
    }