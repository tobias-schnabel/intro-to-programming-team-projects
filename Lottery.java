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

        /* here you should correctly use the two methods below
         * and output for each i from {0,1,2,3,4,5,6) how many lots
         * have had i correctly predicted number
         */



    } //close main

    /* returns an array containing numberOfPicks many
     * distinct integers in the range {1,...,maximumNumber}
     */
    public static int[] draw(int numberOfPicks, int maximumNumber){


    }

    /* returns an array that contains in position i the number
     * of winners having i correct numbers, given an array of lots
     * and an array of drawn numbers
     */
    public static int[] determineWinners(int[][] lots, int[] drawnNumbers){


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

} //close class
