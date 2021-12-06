/* File: PersonData.java
 Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)
 * Implements methods to sort person lists.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PersonData {
   
   public static void main(String args[]){

      ArrayList<Person> personList = null; //declare &init
      
      String filename = "personList200.txt";
      try{
         personList = readPersonList(filename);
         System.out.println("Person list has been read.");
      }
      catch (FileNotFoundException e){
         e.printStackTrace();
      }


      ////////////////// new methods
      removeErrors(personList); //clean data
      System.out.println( personList.size() + " valid entries remaining );

      averageBMI(personList); //compute avg BMI

      System.out.println(numberOfElevators(personList)); //compute # elevators before sorting

      sortWeight(personList); //sort by weight

      System.out.println(numberOfElevators(personList)); //compute # elevators

      //////////////////

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
   public static ArrayList<Person> readPersonList(String filename)
   
     throws FileNotFoundException{
      File file = new File(filename);
      Scanner input = new Scanner (file);
      int n = input.nextInt();

      ArrayList<Person> PersonList = new ArrayList<Person>();
      
      for(int i=0; i<n; i++){
         String firstName = input.next();
         String lastName = input.next();
         int age = input.nextInt();
         int height = input.nextInt();
         int weight = input.nextInt();

         PersonList.add(new Person(firstName, lastName, age, height, weight));
      }
      
      input.close();
      
      return PersonList;
   } //close method

   public static void removeErrors(ArrayList<Person> personList){

      for(int i = 0; i < personList.size(); i++){
         Person candidate = personList.get(i);
         if(candidate.getHeight() == 0){
            personList.remove(i); //?can we just use remove
         }
      } //close for loop
   } //close method

   public static void sortWeight(ArrayList<Person> personList){
      for(int i = 0; i < personList.size(); i++){
         Person person_i = personList.get(i);
         int weight_i = person_i.getWeight();
         for(int j = personList.size() - 1; j > i; j--){ //running index from opposite direction
            Person person_j = personList.get(j);
            if(person_j.getWeight() < weight_i){
               personList.add(i, person_j);
               personList.add(j, person_i);
            } //close if
         } //close for
      } //close for
   } //close method

   public static void averageBMI(ArrayList<Person> personList){

      int[] bmi = new int[6];
      int[] count = new int[bmi.length];

      for(int j = 0; j < personList.size(); j++){
         Person person = personList.get(j);
         int age = person.getAge();
         double bmi = person.getWeight() / (double) Math.pow(((double)person.getHeight()/100),2);
         for(int k = 0; k < bmi.length; k++){
            int lowerBound = 10*(k+2);
            int upperBound = 10*(k+3);
            if(age >= lowerBound && age < upperBound){
               bmi[k] += bmi;
               count[k]++;
            }
         }
      }


} //close class




