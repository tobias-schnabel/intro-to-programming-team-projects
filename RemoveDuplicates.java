/* RemoveDuplicates.java
Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)
Write a method removeDuplicates that takes as input an array of
integer values and that returns the same array, but with duplicate
values being removed.
Write a program RemoveDuplicates that tests your method.*/

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
            int n = in.nextInt();   //length of input array
            int[] arrayIn = new int[n]; //init array

        for(int i = 0; i < n; i++){ //constructs an array of lenght n by means of user input
            System.out.printf("Enter array value %d: ", i+1);
            arrayIn[i] = in.nextInt(); 
        }
        System.out.println("Original Array: " + Arrays.toString(arrayIn));
        System.out.println("Array without duplicates: " + Arrays.toString(removeDuplicates(arrayIn)));
    } //close main

    public static int[] removeDuplicates(int[] array){
        int n = array.length;
        int[] arrayNoDup = new int[n]; //create new, empty array with same length
        int counter =0; //counts non-dups in final array (see inner loop)
        for (int i =0; i < n; i++) {
            boolean isDup = false; //stores whether number is false for each i
            for (int j =0; j < counter; j++){ //second running index
                if (arrayNoDup[j] == array[i]){
                    isDup = true; //number already contained in return array
                }
                } //close inner loop
            if (isDup ==false) { //if for all j, number only present once, it is assigned in output array
                arrayNoDup[counter]=array[i];
                counter++; //ups counter to move to next index in output array
            }
            } //close outer loop

        int[] arrayOut = Arrays.copyOf(arrayNoDup, counter); //creates return array as trimmed copy of output array
        return arrayOut;

    } //close method
}
