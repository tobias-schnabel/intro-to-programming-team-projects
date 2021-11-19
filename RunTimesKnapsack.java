/*RunTimesKnapsack.java
        Authors: Dohmen, RJH (i6250494)
        Schnabel, CT (i6255807)
        Write a program RunTimesKnapsack that implements
        the algorithm that was presented in the lecture to solve the knapsack problem.

        Experimentally analyse the runtime of the algorithm depending on the number of items
        of the instance as well as on the volume bound.

        Given are n items with proﬁts pi and volumes vi as well as a knapsack of volume V .

Which items should be packed in the knapsack as to maximize their total proﬁts, while still having
 total volume at most V ?
 */

import java.util.Random;
import java.util.Scanner;

public class RunTimesKnapsack {

    public static void main(String[] args) {
        // get user input for knapsack algo
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n = in.nextInt();  // item # is n
        System.out.println(" ");

        int[] profitArr = new int[n];
        int[] volumeArr = new int[n];

       // fill profit array
        for(int i = 0; i < n; i++){ //constructs an array of length n by means of user input
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
        System.out.println("Given the constraints, the maximum profit equals " + knapsackOptimize(profitArr, volumeArr, volumeBound));
        double endTime = System.currentTimeMillis();
        double totalTime = endTime - startTime;

        System.out.println("The method took " + totalTime + " milliseconds to complete.");

        //get input for runtime test method
        System.out.println(""); //blank line
        System.out.println("Please input a nonnegative integer lower bound > 0 on volume and profit of an individual item:");
        int lowerBound = in.nextInt();
        System.out.println("Please input a positive integer upper bound on volume and profit of an individual item:");
        int upperBound = in.nextInt();
        System.out.println("Please input how many times you would like to test the method: ");
        int iterations = in.nextInt();

        //call runtime test method
        double[] array; //declare
        array = runtTimeTest(lowerBound, upperBound, iterations);
        System.out.println("The method was executed " + (int) array[0] + " times.");
        System.out.println("For each execution, we generated two arrays of random length up to 100.");
        System.out.println("We then populated these volume and profit arrays of the same length with random numbers between the bounds specified by you and exectued the method on them.\n");
        System.out.println("The method took " + array[1] + " milliseconds in total.");
        System.out.println("The method took " + array[2] + " milliseconds on average.");
        System.out.println("The method took on average " + array[3] + " milliseconds per item.");
    } //close main

        //method takes upper and lower bound and # iterations
    //then iterates n time, generating random volume and profit arrays each and calling the method
    public static double[] runtTimeTest (int l, int u, int n) {
        Random random = new Random(); //init random

        double totaltime = 0; //init timing var
        double timePerLength = 0;
        double[] returnArray = new double[4]; //init return array

        for (int i = 0; i < n; i++){
            int arraylength = random.nextInt(100); //generates random length of volume and profit arrays
            int[] volArr; //declares volume array
                  volArr =   randomPosArr(arraylength, l, u); //populates volume arr
            int[] profArr; //declares profit array
            profArr =   randomPosArr(arraylength, l, u); //populates profit arr
            int volBound = random.nextInt(u);
            double starttime = System.currentTimeMillis();
            int solution = knapsackOptimize(profArr, volArr, volBound); //call method
            double endtime = System.currentTimeMillis();
            totaltime += (endtime - starttime);
            timePerLength += ((endtime - starttime) / arraylength); //computation time per item

        } //close for

        returnArray[0] = n;
        returnArray[1] = totaltime;
        returnArray[2] = totaltime / n; //average time
        returnArray[3] = timePerLength/n ; //total compute time per item

        return returnArray;
    }

            //generates arrays of length n filled with nonnegative Integers between two bounds
    public static int[] randomPosArr(int n, int l, int u){
        Random random = new Random();
        int[] array = new int[n];

        for(int i=0; i < n; i++){
            array[i] = Math.abs(random.nextInt(u-l+1) + l);
        }

        return (array);

    }//close method

    public static int knapsackOptimize(int[] profitArr, int[] volumeArr, int volumeBound){
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
