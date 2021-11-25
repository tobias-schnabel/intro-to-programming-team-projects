/* File: PersonSort.java
 Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)
 * Implements methods to sort person lists.
 */

import java.io.*;
import java.util.*;

public class PersonSort{
   
   public static void main(String args[]){
     
      Person[] personList = null;
      
      String filename = "personList.txt";
      try{
         personList = readPersonList(filename);
         System.out.println("Person list has been read.");
      
      }
      catch (FileNotFoundException e){
         e.printStackTrace();
      }
      
      Scanner input = new Scanner(System.in);
      boolean quit = false;
      
      
      do{
         System.out.println();     
         System.out.println("Enter sort criterion: (1) First Name, (2) Last Name, (3) Age, (4) Height, or (0) to quit.");
      
         int criterion = input.nextInt();
      
         if (criterion == 0){
            quit = true;
         }
         else {
         
		// TO DO
		// sort personList according to criterion

		// output personList

         }
      
      } while (!quit); 
                
     
   }
   
   // method that reads a list of persons from a file and returns an array of persons
   public static Person[] readPersonList(String filename)
   
     throws java.io.FileNotFoundException{
      File file = new File(filename);
      Scanner input = new Scanner (file);
      int n = input.nextInt();
     
      Person[] list = new Person[n];
      
      for(int i=0; i<n; i++){
         String firstName = input.next();
         String lastName = input.next();
         int age = input.nextInt();
         int height = input.nextInt();
      
         list[i] = new Person(firstName, lastName, age, height);
      }
      
      input.close();
      
      return list;
   }
   
   
}




