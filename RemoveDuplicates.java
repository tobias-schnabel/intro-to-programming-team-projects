/* RemoveDuplicates.java
Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)
Write a method removeDuplicates that takes as input an array of
integer values and that returns the same array, but with duplicate
values being removed.
Write a program RemoveDuplicates that tests your method.*/

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
            int n = in.nextInt();   //length of input array
            int[] arrayIn = new int[n]; //init array

        for(int i = 0; i < n; i++){ //constructs an array of lenght n by means of user input
            System.out.printf("Enter array value %d: ", i+1);
            arrayIn[i] = in.nextInt(); 
        }
        System.out.println("Original Array: " + Arrays.toString(arrayIn));
        System.out.println("Array without duplicates: " + Arrays.toString(removeDuplicates(arrayIn, n)));
    } //close main

    public static int[] removeDuplicates(int array[], int n) {

        int arrayTemp[] = new int[n];
        int j = 0;

       /* for(int i = 0; i < n; i++){
            for(j = i+1; j < n){
                if (array[i]==array[j]){
                }
            }
        } */

/*
        int j = 0;
        for (int i = 0; i < n-1; i++){
            if (array[i] != array[i+1]){
                arrayTemp[j++] = array[i];
            }
        }
        arrayTemp[j++] = array[n-1];
        /*
        for (int i = 0; i < j; i++){
            arrayIn[i] = arrayTemp[i];
        }*/

        return null; //stub
    } //close method
}
