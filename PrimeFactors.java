/* PrimeFactors.java
Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)
Write a Java method printPrimeFactors of return type void that has one int parameter n
and that outputs the prime factorization of n(e.g. n=84=2·2·3·7) on the screen.
To test your method, write a program PrimeFactors.java that takes as input a positive integer
parameter and then calls the above printPrimeFactors method with that parameter.
*/

import java.util.Scanner;

public class PrimeFactors {
    public static void main(String[] args) throws Exception {

        System.out.print("Enter a positive integer n = ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        PrimeFactors(n);

    }//close main

    public static void PrimeFactors(int n){
        
        double startTime = System.currentTimeMillis();  
        printPrimeFactors(n);
        double endTime = System.currentTimeMillis();
        double totalTime = endTime - startTime; 
        //calculates the run time of method printPrimeFactors

        System.out.print("The method took " + totalTime + " milliseconds to run.");

    }//close method

    public static void printPrimeFactors(int n){

        System.out.print("The prime factorization of " + n + " is: ");

        for(int i = 2; i< n; i++) { 
            while(n % i == 0) {
               System.out.print(i + " · ");
               n = n / i; //removes prime factor from the original number n
            }
         }
         if(n >2) { //in case n is a prime number
            System.out.println(n);
        }
    }//close method
}
