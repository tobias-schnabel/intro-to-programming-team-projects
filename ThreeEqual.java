import java.util.Scanner;

public class ThreeEqual {

	public static void main(String[] args) {
   
      Scanner in = new Scanner(System.in);
      
         System.out.print("Enter the first number: ");
            int Nr1 = in.nextInt();
            
         System.out.print("Enter the second number: ");
            int Nr2 = in.nextInt();
            
         System.out.print("Enter the third number: ");
            int Nr3 = in.nextInt();
           
           
      System.out.println("The given numbers are: " + Nr1 + ", " + Nr2 + ", " + Nr3);     
            
            
      if (Nr1 == Nr2 && Nr1 == Nr3) {System.out.println("All three numbers are equal");
         }
         
      else System.out.print("These three numbers are not all equal");
       
            
     }
     
}