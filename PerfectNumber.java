/* DayOfWeek.java
Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)*/

import java.util.Scanner;

/*A positive integer is called perfect, if the sum of its proper divisors is equal to the number
(e.g. 6 = 1+2+3, 28 = 1 + 2 + 4 + 7 + 14). Write a method isPerfectNumber of return type boolean
that has one int parameter n and that returns true if n is a perfect number. Write a program PerfectNumber
that takes as input a positive integer parameter and then calls the above isPerfectNumber method with that
parameter and outputs a corresponding message.
 */

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter an integer number bigger than 2: ");
        int n = in.nextInt(); //get input
        int perfNum = 0; //declare and init output
        if (isPerfectNumber(n)) {
            System.out.print(n + " is a perfect number");
        } else{
            System.out.print(n + " is not perfect number");
    }
    } //close main
    public static boolean isPerfectNumber(int n) {


} //close class
