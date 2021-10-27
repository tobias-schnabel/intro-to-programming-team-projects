import java.util.Scanner;

public class Seasons {

   public static void main(String[] args) {
   
      Scanner in = new Scanner(System.in);
      
   System.out.print("Enter a day: ");
      int Day = in.nextInt();
   
   System.out.print("Enter a month: ");
      int Month = in.nextInt();
      
      
      System.out.print(Day+"."+Month+". is during ");
      
   
   if (Month == 12 || Month < 3) {if (Month == 12 && Day <= 20) {System.out.print("Fall.");
                                 }else if (Month == 12 && Day >= 21) {System.out.print("Winter.");
                                 }else if (Month < 3) {System.out.print("Winter.");
                                 }}
                                 
   else if (Month == 3 || Month < 6) {if (Month == 3 && Day <= 20) {System.out.print("Winter.");
                                     }else if (Month == 3 && Day >= 21) {System.out.print("Spring.");
                                     }else if (Month > 3 && Month < 6) {System.out.print("Spring.");
                                     }}
                                     
  else if (Month == 6 || Month < 9) {if (Month == 6 && Day <= 20) {System.out.print("Spring.");
                                    }else if (Month == 6 && Day >= 21) {System.out.print("Summer.");
                                    }else if (Month > 6 && Month < 9) {System.out.print("Summer.");
                                    }}
                                    
  else if (Month == 9 || Month < 12) {if (Month == 9 && Day <= 20){System.out.print("Summer.");
                                     }else if (Month == 9 && Day >= 21) {System.out.print("Fall.");
                                     }else if (Month > 9 && Month < 12) {System.out.print("Fall.");
                                     }}
     

      
   }
}