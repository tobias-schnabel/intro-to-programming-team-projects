/*RunTimesKnapsack.java
        Authors: Dohmen, RJH (i6250494)
        Schnabel, CT (i6255807)
        Write a program RunTimesKnapsack that implements
        the algorithm that was presented in the lecture to solve the knapsack problem.

        Experimentally analyse the runtime of the algorithm depending on the number of items
        of the instance as well as on the volume bound.

        Given are n items with p roﬁts p i and volumes v i as well as a kna p sack of volume V .

Which items should be p acked in the kna p sack as to maximize their total p roﬁts, while still having
 total volume at most V ?
 */

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class RunTimesKnapsack {

    public static void main(String[] args) {
        // get user input for knapsack algo
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        System.out.println(" ");
        int n = in.nextInt();  // item # is n

        int[] profitArr = new int[n];
        int[] volumeArr = new int[n];

       // fill profit array
        for(int i = 0; i < n; i++){ //constructs an array of lenght n by means of user input
            System.out.printf("Enter the profit of item %d: ", i+1);
            profitArr[i] = in.nextInt();
        }
        System.out.println(" ");

        // fill volume array
        for(int i = 0; i < n; i++){ //constructs an array of lenght n by means of user input
            System.out.printf("Enter the volume of item %d: ", i+1);
            volumeArr[i] = in.nextInt();
        }
        System.out.println(" ");
        System.out.print("Enter the volume bound: ");
        int volumeBound = in.nextInt();
        System.out.println(" ");

        double startTime = System.currentTimeMillis();
        System.out.println("Given the constraints, the maximum profit equals " + KnapsackOptimize(profitArr, volumeArr, volumeBound));
        double endTime = System.currentTimeMillis();
        double totalTime = endTime - startTime;

        System.out.println("The method took " + totalTime + " milliseconds to complete.");

        //get input for runtime test method
        System.out.println("Please input an integer upper bound on volume and profit of an individual item:");
        int upperBound = in.nextInt();
        System.out.println("Please input an integer lower bound on volume and profit of an individual item:");
        int lowerBound = in.nextInt();
        System.out.println("Please input how many times you would like to test the method: ");
        int iterations = in.nextInt();

        //call runtime test method
        int[] array = new int[3] //total time, average time ??
    } //close main

    public static int[] runtTimeTest ()

            //generates arrays of length n filled with nonnegative Integers between two bounds
    public static int[] randomPosArr(int n, int l, int u){
        Random random = new Random();
        int[] array = new int[n];

        for(int i=0; i < n; i++){
            array[i] = Math.abs(random.nextInt(u-l+1) + l);
        }

        return (array);

    }//close method

    public static int KnapsackOptimize(int[] profitArr, int[] volumeArr, int volumeBound){
        int n = profitArr.length; //number of items is same as # elements in profit array
        int[][] returnArray = new int[(n + 1)][(volumeBound + 1)]; //creates return array with dims [n+1] [V+1]
        for (int i = 1; i <= n; i++) {
        for (int v = 0; v <= volumeBound; v++){
            if (i == 0 || v == 0) {
                returnArray[i][v] = 0; //base case
            } else if (volumeArr[i-1] <= v) { //if we include item
                returnArray[i][v] = Math.max((profitArr[i-1] + returnArray[i-1][(v - volumeArr[i-1])]), returnArray[i-1][v]);
            } else { //if we do not include the item
                returnArray[i][v] = returnArray[i-1][v];
            }
                } //close inner for
            } //close outer for

    return returnArray[n][volumeBound];

    } //close method
} //close class
