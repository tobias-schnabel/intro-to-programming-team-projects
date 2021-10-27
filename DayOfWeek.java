/* DayOfWeek.java
Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)*/
         
import java.util.Scanner;
import java.lang.Math;

public class DayOfWeek {

	public static void main(String[] args) {
   
      Scanner in = new Scanner(System.in);
   
   System.out.print("Enter a day: ");
      int d = in.nextInt();
      
   System.out.print("Enter a month: ");
      int m = in.nextInt();
      
   System.out.print("Enter a year: ");
      int y = in.nextInt();
         
         //entering the given formulas
         int Yo = y-(14-m)/12;
         int x = Yo+(Yo/4)-(Yo/100)+(Yo/400);
         int Mo = m+12*((14-m)/12)-2;      
         int Do = (d+x+(31*Mo)/12)%7;
         
      
   System.out.print(d + "." + m + "." + y + " is a ");
      
      
      if (Do < 3) {if (Do == 0) {System.out.print("Sunday.");
                  }if (Do == 1) {System.out.print("Monday.");
                  }if (Do == 2) {System.out.print("Tuesday.");
                  }} 
                  
      else if (Do >= 3){if (Do == 3) {System.out.print("Wednesday.");
                       }if (Do == 4) {System.out.print("Thursday.");
                       }if (Do == 5) {System.out.print("Friday.");
                       }if (Do == 6) {System.out.print("Saturday.");
                       }}
     }
}