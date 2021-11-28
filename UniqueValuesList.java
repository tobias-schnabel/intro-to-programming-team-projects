/*
*/

import java.util.*;

public class UniqueValuesList {
    public static void main(String[] args) throws Exception {

        System.out.print("Enter the size of the array: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] array = randomIntArray(n);
        System.out.println("Original array: " + Arrays.toString(array));

        uniqueList(array);

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

    public static ArrayList<Integer> uniqueList(int[] array){

        int n = array.length;
        int[] arrayNoDup = new int[n]; //create new array
        int counter =0; //counts non-dups in final array (see inner loop)
        for (int k : array) {
            boolean isDup = false; //stores whether number is false for each i
            for (int j = 0; j < counter; j++) { //second running index
                if (arrayNoDup[j] == k) {
                    isDup = true; //number already contained in return array
                    break;
                }
            } //close inner loop
            if (!isDup) { //if for all j, number only present once, it is assigned in output array
                arrayNoDup[counter] = k;
                counter++; //ups counter to move to next index in output array
            }
        } //close outer loop
        int[] finalArray = Arrays.copyOf(arrayNoDup, counter);
        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(finalArray));


       return arrayList;
     
    } //close remove duplicates method
}   


