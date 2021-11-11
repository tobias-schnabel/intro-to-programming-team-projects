/* Lottery.java
Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)
  In this exercise you will write some Java methods that can be used to simulate a
  lottery drawing. A lot can be bought for 1 Euro, and a player has to pick six distinct
  (integer) numbers between 1 and 49.

The six winning numbers will be drawn at random
(all combinations of six distinct numbers are equally likely).
In the provided ﬁled lottery1.txt you can ﬁnd the six picked numbers for 1000 lots.
 Moreover, in the ﬁle Lottery.java you already ﬁnd a part of the main method, a method
 that can read the lots from a ﬁle, as well as the signatures of the two methods that you
 have to implement, together with some comments.

 (a) Implement the method draw that returns an array containing six distinct random integers between 1 and 49.
 (b) Implement the method determineWinners according to the given description in the comment.
 (c) Complete the main method to produce reasonable output.

 */
import java.util.*;
import java.io.*;

public class Lottery {

    public static void main(String[] args){

        int numberOfPicks = 6;
        int maximumNumber = 49;

        int[][] lots = null;
        try{
            lots = readLots(args[0]);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        System.out.println("The drawn numbers are: " + Arrays.toString(draw(numberOfPicks, maximumNumber)) );

        /* here you should correctly use the two methods below
         * and output for each i from {0,1,2,3,4,5,6) how many lots
         * have had i correctly predicted number
         */
        int[] drawnNumbers = draw(numberOfPicks, maximumNumber);
        int[] winningNums = determineWinners(lots, drawnNumbers);

        for (int i=0; i < 7; i++){
            System.out.println("Lots with " + i + " correct number(s): ");
            System.out.println(winningNums[i]);
        }


    } //close main

    /* returns an array containing numberOfPicks many
     * distinct integers in the range {1,...,maximumNumber}
     */
    public static int[] draw(int numberOfPicks, int maximumNumber){
            //produces an array of length n containing random integers
            Random random = new Random();
            int[] array = new int[numberOfPicks];
            for (int i = 0; i < 6; i++) {
                array[i] = 1+ random.nextInt(maximumNumber); //randomInt bounded below by 0, add 1 to lowerbound 1
            }
            array = removeDuplicates(array);
        if (array.length == 6) {
            return array;
        } else {
            System.out.println("The random number generator generated identical random integers, please try again");
            return null;

        }
        } //close draw mehtod


    /* returns an array that contains in position i the number
     * of winners having i correct numbers, given an array of lots
     * and an array of drawn numbers
     */
    public static int[] determineWinners(int[][] lots, int[] drawnNumbers){
        int numberOfPicks = 6; //has to be replaced here because given method signature does not allow for passing odf this arg
        int n = drawnNumbers.length;

        int[] winningArr = new int[7];

        for (int[] lot : lots) {
            int counts = 0;
            for (int drawnNumber : drawnNumbers) {
                for (int k = 0; k < n; k++) {
                    if (lot[k] == drawnNumber) {
                        counts += 1;
                    }
                } //close innermost loop
            } //close inner loop
            for (int x = 0; x < numberOfPicks; x++) {
                if (counts == x) {
                    winningArr[x]++;
                }
            } //close outer loop

        }
        return winningArr;
    }

    public static int[][] readLots(String filename)
            throws java.io.FileNotFoundException{
        File file = new File(filename);
        Scanner input = new Scanner (file);

        int numberOfLots = input.nextInt();

        int[][] lots = new int[numberOfLots][6];

        for (int i=0;i<numberOfLots;i++){
            for (int j=0;j<6;j++){
                lots[i][j] = input.nextInt();
            }
        }
        input.close();
        return lots;
    }

    public static int[] removeDuplicates(int[] array){
        int n = array.length;
        int[] arrayNoDup = new int[n]; //create new, empty array with same length
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

        return Arrays.copyOf(arrayNoDup, counter);
    } //close remove duplicates method




} //close class
