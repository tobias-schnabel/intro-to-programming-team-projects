/* LetterCount.java
Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)
Write a program LetterCount that can determine the percentages
 of each letter occurring in a given list of words.
 The program should take as an argument the filename
 of the file containing the words.*/

 import java.util.*;
 import java.io.*;

/*Write a program LetterCount that can determine the percentages of
each letter occurring in a given list of words. The program should take
as an argument the ﬁlename of the ﬁle containing the words. A sample ﬁle of
words is provided in Canvas. The program should contain a method with the following
signature that reads the words line by line from the ﬁle and returns an array of integers
 of length 26, where the ith element of the array equals the number of occurences of the ith
 letter of the alphabet in that list of words.

public static int[] readWords(String filename)

 */
public class LetterCount {

    public static void main(String[] args) {

        String filename = args[0];
        int[] stringArray = null; //declare and init

        try {
            stringArray = readWords(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < stringArray.length; i++) {
            System.out.println(stringArray[i]);
        }
        System.out.println(Arrays.toString(stringArray));

    } //close main

    public static int[] readWords(String filename)

            throws java.io.FileNotFoundException {
        File file = new File(filename);
        Scanner input = new Scanner(file);

        int counter = 0; //number of rows as int
        while (input.hasNextLine()) {
            counter++;
        }

        String[] stringArray = new String[counter];
        while (input.hasNextLine()) {
            for (int i = 0; i < counter; i++) {
                stringArray[i] = input.nextLine();
            }
            input.close();
        }

        String[] returnArray = new String[26]; //declare and init return variable

        int[] counts = new int[26];
        for (String string : stringArray) {
            String lowercaseLine = string.toLowerCase();
            for (char letter : lowercaseLine.toCharArray()) {
                int index =  letter - 'a';
                counts[index]++; //how often each letter occurs in line
            }
        }


        return counts;

    } //close readword method
    //public static int[]
} //close class
