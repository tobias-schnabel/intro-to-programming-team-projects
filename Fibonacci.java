/* DayOfWeek.java
Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)*/

import java.util.Scanner;

/*The Fibonacci numbers are an integer sequence deﬁned as follows: F 0 = 0, F 1 = 1, and F n = F n−2 + Fn−1
for every n ≥ 2. The beginning of the sequence is therefore 0, 1, 1, 2, 3, 5, 8, 13.3
Write a program Fibonacci that takes a positive integer n as input and outputs the value of F n .
Experiment a bit to see what the largest value of n is so that you can compute F n .
 */
public class Fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter an integer number bigger than 2: ");
        int n = in.nextInt(); //get input
        int fibSeq = 0; //declare and init output
        System.out.print("The Fibonacci number is: "+ FibLoop(n));
    }

    public static int FibLoop(int n) {

            int n1 = 0, n2 = 1, n3=1, i;
            for (i = 2; i <= n; ++i) {
                n3 = n1 + n2;
                n1 = n2;
                n2 = n3;
            }
            return n3;
        }
    }
