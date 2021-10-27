import java.util.Scanner;

public class Fractions {
   
   public static void main(String[] args) {
 
   Scanner in = new Scanner(System.in);
 
   System.out.print("Enter the numerator of the first fraction: ");
      int N1 = in.nextInt();
      
   System.out.print("Enter the denominator of the first fraction: ");
      int D1 = in.nextInt();
     
   System.out.print("Enter the numerator of the second fraction: ");
      int N2 = in.nextInt();
   
   System.out.print("Enter the denominator of the second fraction: ");
      int D2 = in.nextInt();
   
      //sum
      int NumSum = (N1 * D2) + (N2 * D1);
      int DenSum = (D1 * D2);
      
      //Product
      int NumProd = (N1 * N2);
      
   System.out.println("(" + N1 + "/" + D1 + ") + (" + N2 + "/" + D2 + ") = " + NumSum + "/" + DenSum);
   System.out.println("(" + N1 + "/" + D1 + ") * (" + N2 + "/" + D2 + ") = " + NumProd + "/" + DenSum);
      
     
   }
}