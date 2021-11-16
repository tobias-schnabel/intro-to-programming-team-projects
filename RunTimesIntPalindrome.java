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

        System.out.print("Enter a positive integer n = ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        double startTime1 = System.currentTimeMillis();
        System.out.println("isIntPalindromeLong: " + isIntPalindromeLong(n));
        double endTime1 = System.currentTimeMillis();
        double totalTime1 = endTime1 - startTime1;  //calculates the run time of method isIntPalindromeLong

        double startTime2 = System.currentTimeMillis();
        System.out.println("isIntPalindromeSmart: " + isIntPalindromeSmart(n));
        double endTime2 = System.currentTimeMillis();
        double totalTime2 = endTime2 - startTime2;  //calculates the run time of method isIntPalindromeSmart

        System.out.println("The method isIntPalindromeLong took " + totalTime1 + " milliseconds to complete.");
        System.out.println("The method isIntPalindromeSmart took " + totalTime2 + " milliseconds to complete.");

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

        int arrayLength = (int) Math.log10(n) + 1;  //define array length (hint)
        int[] array  = new int[arrayLength];        //init array
        int j = 0;                                  //init j
        boolean isPalindrome = true;

        while(n != 0){  //converts n into an array of its digits
            array[arrayLength-j-1] = n % 10; //assigns values to array in descending order and
            n =n/10; //moves to next number in int
            j++; //increases placeholder to fill next index in array (front to back)
        }//close loop

        for (int i = 0; i < arrayLength-1; i++){
            if(array[i] == array[arrayLength-1-i]){
                isPalindrome = true; //compares digits in opoosite directions
            }
            else {isPalindrome = false;  
            break; //breaks loop in case one element does not match
            }
        }//close loop  
        return isPalindrome; 

    }//close method

}//close class


