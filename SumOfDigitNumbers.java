
/* DayOfWeek.java
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
    public class SumOfDigitNumbers {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);


            System.out.print("Enter an integer n>1 ");
            int n = in.nextInt(); //get input, # of digits


    }//close main
/*
    public static int numGen(int n){
            int sum =0;
            for (int i=0; i<=9; i++){ //gen all possible numbers
              sum += i;
                int num = i;
                int sum = 0;
                while (num > 0) {
                    sum = sum + num % 10;
                    num = num / 10;
                }

        }

    } //close method


} //close class
*/}