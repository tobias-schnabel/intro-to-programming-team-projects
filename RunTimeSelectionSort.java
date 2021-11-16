/* RunTimeSelectionSort.java
Authors: 

Write a method selectionSort of return type void that takes one integer array 
as a parameter and sorts the values in the array using the selection sort algorithm 
presented in the lecture. Write a program RunTimesSelectionSort that generates random integer
arrays and tests the runtime of the above method. */

import java.util.*;

public class RunTimeSelectionSort{

    public static void main(String[] args){

        System.out.print("Enter the size of the array: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] array = randomIntArray(n);
        System.out.println("Unsorted array: " + Arrays.toString(array));

        RunTimeSelectionSort(array);

    }//close main

    public static int[] randomIntArray(int n){
        //produces an array of length n containing random integers
        Random random = new Random();
        int[] array = new int[n];
        for(int i=0; i < n; i++){
           array[i] = random.nextInt();
        }
        return array;

    }//close method

    public static void RunTimeSelectionSort(int[] array){

        double startTime = System.currentTimeMillis();
        selectionSort(array);
        double endTime = System.currentTimeMillis();
        double totalTime = endTime - startTime;     //calculates the run time of method selectionSort
        
        System.out.println("The method took " + totalTime + " milliseconds to complete.");

    }//close method

    public static void selectionSort(int[] array){

        for(int i = 0; i < array.length-1; i++){
            int minIndex = i;             //index of smallest element in array[i...n]
            for(int j = i+1; j < array.length; j++){ //traversing array
                if (array[j] < array[minIndex]){ //sets the index of the smallest array value to j
                    minIndex = j;         
                }
            }//close inner loop
            int temp = array[minIndex];   //temporary variable to store minimal array value while swapping
            array[minIndex] = array[i];   //swap smallest array element to the front of the array
            array[i] = temp;
        }//close loop
        
        System.out.println("Sorted array: " + Arrays.toString(array));

    }//close method

}//close class
