/* StandardDeviation.java
Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)*/
    /*Write a method standardDeviation of return type double that takes as parameter an array of
     double values and returns the standard deviation of the values contained in the array.
The standard deviation of a set of n real numbers { a 1 , a 2 , . . . , a n } is deﬁned as */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class StandardDeviation {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter how many elements the array should contain");
        int n = in.nextInt();  // number of elements of array is n
        double[] array = randomDoubleArray(n);
        System.out.println("The std. dev. of the randomly generated string " + Arrays.toString(array) + " is " + standardDeviation(array));
    } //close main

    public static double standardDeviation(double[] arrayIn) {
        //get mean of array from other method once
        double mean = arrayMean(arrayIn);

        double sum = 0; // sum of squared deviations
        for (double value : arrayIn) {
            sum += Math.pow((value - mean), 2);
        }

        double sd = Math.sqrt((sum / arrayIn.length));
        return sd;
    } //close method

    // returns an array of length n containing random double values
    public static double[] randomDoubleArray(int n){
        Random random = new Random();
        double[] array = new double[n];
        for(int i=0; i < n; i++){
            array[i] = random.nextDouble();
        }
        return array;
    } //close method

    public static double arrayMean(double[] arrayIn) {
        double sumElements = 0;
        for (double x : arrayIn) {
            sumElements += x; // running total
        }
        double arrayMean = sumElements / arrayIn.length; //divide by length to get mean
        return arrayMean;
    } //close method

} //close class
