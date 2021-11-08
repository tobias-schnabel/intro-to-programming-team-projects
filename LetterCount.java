/* LetterCount.java
Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)
Write a program LetterCount that can determine the percentages
 of each letter occurring in a given list of words. 
 The program should take as an argument the filename 
 of the file containing the words.*/

 import java.util.*;
 import java.io.*;

public class LetterCount { 
    public static void main(String[] args) throws Exception {

      String filename = args[0];
      String[] stringArray = null;

      try{
        stringArray = readWords(filename);
      }
      catch (FileNotFoundException e){
        e.printStackTrace();
      }
      for(int i = 0; i < stringArray.length; i++){
        System.out.println(stringArray[i]);
      }
    }
  
  public static String[] readWords(String filename)

    throws java.io.FileNotFoundException{
      File file = new File(filename);
      Scanner input = new Scanner (file);
    
    int n = input.nextInt();
    
    String[] stringArray = new String[n];
    
      for (int i=0;i<n;i++){
        stringArray [i] = input.nextLine();
      }    
    input.close();
    
    return stringArray;
    }
}
