
/* SumofDigitSumNumbers.java
Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)*/

import java.util.Scanner;

/*A digit sum number is a positive integer, which contains a digit
that is equal to the sum of all the other digits. There are no
digit sum numbers which have one digit, and all digit sum numbers with two digits
are multiples of 11. Some examples of digit sum numbers having three digits are
352 (5 = 3+2), 312 (3 = 1+2) and 134 (4 = 1 + 3). Write a program SumOfDigitSumNumbers
 that takes as input a positive integer value n and outputs the sum of all digit sum numbers
  which have at most n digits. */

/*break problem down into 3 methods:
1. main for I/O
2. for loop iterates all possible # with n digits and for each iteration calls
3. method that checks whether number is digit sum number
*/
    public class SumOfDigitNumbers {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);

            System.out.println("Enter an integer n>1 ");
            int n = in.nextInt(); //get input, # of digits

            System.out.println("The sum of all digit sum numbers that have at most " + n +" digits is: " + numGen(n));

    }//close main

    public static int numGen(int n){

            int sumDigitSumNum = 0; //declare and init Sum output

            for (int currentNum=0; currentNum <= (Math.pow(10, n)-1); currentNum++){ //gen all possible numbers with n digits
             if  (isDigitSumNumber(currentNum , n)) { //invoke digit sum number check method
                 sumDigitSumNum += currentNum; // return to sum
             }
            } //close loop
        return sumDigitSumNum; //returns final sum of all digit sum numbers
    } //close method

    public static Boolean isDigitSumNumber (int candidateNum, int n) {

        int sumOfDigits = 0; //declare and init sum of digits
        int currentMaxDigit = -1;
        for (int i = 0; i <= n; i++) {
            int candidateDigit = candidateNum % 10;
            if (candidateDigit > currentMaxDigit) { //compares each digit to current max and replaces max if >
                currentMaxDigit = candidateDigit;
            }
            sumOfDigits += candidateDigit; //adds candidate digit to sum of digits
            candidateNum = candidateNum / 10; //moves to next digit
        }
        if (sumOfDigits == 2 * currentMaxDigit) { //if true, candidate number is digit sum number
            return true;
        } else {
            return false;
        }
    } //close method

} //close class
