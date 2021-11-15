/*RunTimesMatrixMulitplication.java
        Authors: Dohmen, RJH (i6250494)
        Schnabel, CT (i6255807)

        Write two methods minAbsoluteValueLinear and minAbsoluteValueBinary.
        Both methods take as input a sorted array of integer values and return
        the smallest absolute value of the entries in the array. The ﬁrst method
        should go through the whole array from the ﬁrst to the last element, while
         the second method should use binary search.

        Write a program that can generate random sorted integer arrays and that can test
        and compare the runtimes of the two methods above for arrays of varying length. */

import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class MinAbsoluteValue {


    public static int minAbsoluteValueLinear(int[] array) {
        int minValue = 0;
        for (int i = 0; i < array.length; i++) {
            if (Math.abs(array[i]) < Math.abs(minValue) ) {
                minValue = array[i];
            }
        }
        return minValue;
    } //close method

    public static int minAbsoluteValueBinary(int[] array) {
        int minValue = 0;
        int low = 0;
        int high = array.length -1;
        while (low+1 < high ) {
            int mid = (high + low) /2;

            if (Math.abs(array[mid]) < Math.abs(minValue) ) {
                minValue = array[mid];
            } else if (Math.abs(array[mid]) == Math.abs(minValue)){
                break;
            } else if (Math.abs(array[mid]) > Math.abs(minValue)) {
                low = mid;
            }

        return minValue;
    } //close method

} // closeclass
