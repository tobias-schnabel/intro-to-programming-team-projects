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
      int numberOfPersons = personList.length;
      
      do{
         System.out.println();     
         System.out.println("Enter sort criterion: (1) First Name, (2) Last Name, (3) Age, (4) Height, or (0) to quit.");
      
         int criterion = input.nextInt();
      
         if (criterion == 0){ //quit
            quit = true;
         }
         else if (criterion == 1){ // first name
            String[] firstNames = new String[numberOfPersons];
            for(int i = 0; i < numberOfPersons; i++){
               firstNames[i] = personList[i].getFirstName();
            }
            letterSort(firstNames); // invokes letterSort method for first names
         }
         else if (criterion == 2){ // last name
            String[] lastNames = new String[numberOfPersons];
            for(int i = 0; i < numberOfPersons; i++){
               lastNames[i] = personList[i].getLastName();
            }
            letterSort(lastNames);  // invokes letterSort method for last names
         }
         else if (criterion == 3){ // age
            int[] age = new int[numberOfPersons];
            for(int i = 0; i < numberOfPersons; i++){
               age[i] = personList[i].getAge();
            }
            numberSort(age);  // invokes numberSort method for ages
         }
         else if (criterion == 4){ // height
            int[] height = new int[numberOfPersons];
            for(int i = 0; i < numberOfPersons; i++){
               height[i] = personList[i].getHeight();
            }
            numberSort(height);  // invokes numberSort method for height
         }
      }
       while (!quit);

         } //close main

      public static void letterSort(String[] array){ // alphabetical selection sort algorithm
            
         String temp;  //temporary string to store array value while swapping
         for(int i = 0; i < array.length; i++){
            for(int j = i+1; j < array.length; j++){
               if(array[i].compareTo(array[j])>0){
                  temp = array[i];
                  array[i]=array[j];
                  array[j]=temp;
               }
            }
         }
         System.out.print("Sorted: " + Arrays.toString(array));
      }
            

      public static void numberSort(int[] array){  //selection sort algorithm

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
          System.out.print("Sorted: " + Arrays.toString(array));
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

} //close class




