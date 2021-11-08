/* GCD.java
Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)
Write a program GCD.java that takes two positive integer parameters
as input and outputs their greatest common divisor.
The greatest common divisor of two numbers m and n 
is the largest integer that divides both m and n. */

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) throws Exception {

        System.out.println("Enter two positive integers: ");
        Scanner in = new Scanner(System.in);
            int m = in.nextInt();
            int n = in.nextInt();

        System.out.print("1. Recursive method: the greatest common divisor of ");
        System.out.println(m + " and " + n + " is: " + recursiveMethod(m, n));

        System.out.print("2. Non-recursive method: the greatest common divisor of ");
        System.out.println(m + " and " + n + " is: " + nonRecursiveMethod(m, n));
    }

    public static int recursiveMethod(int m, int n){

        //Euclid's algorithm
        if (n % m == 0){return m;
        }
        else { return recursiveMethod(n, m % n);
        }
    }
    
    public static int nonRecursiveMethod(int m, int n){
        
        //using q as an intermediate value to store 
        //n while reassigning
        int q = 0;
        while (n % m != 0){
            q = n;
            n = m % n;
            m = q;
        }
        return q;
    }
}
