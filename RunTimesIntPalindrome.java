/*RunTimesMatrixMulitplication.java
        Authors: Dohmen, RJH (i6250494)
        Schnabel, CT (i6255807)
Write two methods isIntPalindromeLong and isIntPalindromeSmart of return type boolean 
that both take a positive integer parameter as input and return true if the parameter 
is an integer palindrome, i.e. a number that is equal when read from left to right and from 
right to left (e.g. 131, 1435341).

The method isIntPalindromeLong will first compute the reverse integer to the input number 
and then return true if and only if it is equal to the input number. The method isIntPalindromeSmart 
will compare “opposite” digits one by one, starting with the first and the last digit, and return 
false if they differ and continue otherwise. If no such different digits have been found, 
it will return true.You are allowed to use only numerical operations (and no String operations).

Write a program RunTimesIntPalindrome that can test and compare the runtimes of the two methods
above for input numbers of different magnitudes.
Hint: in Java you can use the Math.log10() method to determine the logarithm base 10 of a number, 
i.e. (int) Math.log(n) +1 will return the number of digits of n. */

import java.util.*;
import java.lang.Math;

public class RunTimesIntPalindrome {
    public static void main(String[] args) {

        System.out.print("Enter how many iterations you would like to test the methods on: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Random rand = new Random();

        double runTime1 = 0;
        double runTime2 = 0;

        for(int i = 0; i < n; i++) {
            int k = Math.abs(rand.nextInt()); //methods only work with positive integer input
            double startTime1 = System.currentTimeMillis();
            isIntPalindromeLong(k);
            double endTime1 = System.currentTimeMillis();
            runTime1 += (endTime1 - startTime1);

            double startTime2 = System.currentTimeMillis();
            isIntPalindromeSmart(n);
            double endTime2 = System.currentTimeMillis();
            runTime2 += (endTime2 - startTime2);
        }

        System.out.println("For " + n + " tries, isIntPalindromeLong took in total " + runTime1 + " milliseconds.");
        System.out.println("For " + n + " tries, isIntPalindromeLong took on  average " + runTime1/n + " milliseconds.");
        System.out.println("");
        System.out.println("For " + n + " tries, isIntPalindromeSmart took in total " + runTime2 + " milliseconds.");
        System.out.println("For " + n + " tries, isIntPalindromeSmart took on  average " + runTime2/n + " milliseconds.");
        System.out.println("");
        System.out.println("Validation:");
        System.out.println("For the palindrome number 1435341, the Smart Method returns: " + isIntPalindromeSmart(1435341));
        System.out.println("And for the same palindrome number, the Long Method returns: " + isIntPalindromeLong(1435341));


    }//close main

    public static boolean isIntPalindromeLong(int n){

        int originalInt = n; //introduce variable to keep n unchanged throughout the loop
        int reverseInt = 0;  //init reverseInt

        while(originalInt != 0){ //calculates the reverse int to the input number
            int remainder = originalInt % 10;
            reverseInt = reverseInt*10 + remainder;
            originalInt = originalInt/10;
        }//close loop

        if (n == reverseInt){ //returns true if input number equals its reverse
            return true;
        }
        else return false;  

    }//close method

    public static boolean isIntPalindromeSmart(int n){
        int intLength = (int) Math.log10(n) + 1; //# digits
        boolean isPalindrome = true; //initialize return var
        int i =0; //loop index
        while (i < intLength ) {
            int lastDigit = n % 10;
            int firstDigit = n / (int) Math.pow(10, intLength-1);
            if (lastDigit != firstDigit) {
                isPalindrome = false;
                break;
            } else {
                n = n / 10; //take out last digit
                n = n / (int) Math.pow(10, intLength -1); //take out first digit
                intLength -= 2; //shorten # digits by 2
                i++;
            }
        } //close loop
        return isPalindrome;
    } //close method

}//close class


