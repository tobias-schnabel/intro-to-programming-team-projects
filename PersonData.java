/* File: PersonData.java
 Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)
 * Implements methods to sort person lists.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
      if(personList != null){ //redundant?
         removeErrors(personList); //clean data
         System.out.println(personList.size() + " valid entries remain after cleaning erroneous observations. \n");

         averageBMI(personList); //compute avg BMI

         int initialResult = numberOfElevators(personList);
         System.out.println("\n" + initialResult + " elevators are required."); //compute # elevators before sorting

         sortWeightAscending(personList); //sort by weight ascending
         int resultAscending = numberOfElevators(personList); //compute # elevators

         sortWeight(personList); //sort by weight descending
         int resultDescending = numberOfElevators(personList); //compute # elevators again

         if (resultAscending < resultDescending && resultAscending < initialResult){
            System.out.println("Sorting the list by weight in ascending order improved our result by " + (initialResult - resultAscending) + ".");
         } else if (resultAscending > resultDescending && resultDescending < initialResult){
            System.out.println("Sorting the list by weight in descending order improved our result by " + (initialResult - resultDescending) + ".");
         } else { System.out.println("Sorting the list by weight does not lead to an improvement in our result");}
      }
      //////////////////

         } //close main



   public static int numberOfElevators(ArrayList<Person> personList){
      ArrayList<Integer> numberOfElevators = new ArrayList<>(); //declare
      numberOfElevators.add(0); //init
      int entries; //declare
      int weight; //declare
      int totalWeight = 0; //init
      //traverse personList
      for(Person candidate : personList){
         weight = candidate.getWeight();
         entries = 0; //init
         while(weight != 0){
            if(numberOfElevators.get(entries) + weight <= 450){ //if person fits in bin, place there
               numberOfElevators.set(entries, numberOfElevators.get(entries) + weight);
               totalWeight +=weight;
               weight = 0; //reset
            }

            else if(entries < numberOfElevators.size()-1){
               entries++; //check next elevator if available
            }

            else if(entries == numberOfElevators.size()-1){
               numberOfElevators.add(weight); //add additional elevator if necessary
               totalWeight += weight;
               weight = 0;

            }
         }
      }
      //returns number of elevator runs necessary
      return numberOfElevators.size();
   }
   
   // method that reads a list of persons from a file and returns an array of persons
   public static ArrayList<Person> readPersonList(String filename)
   
     throws FileNotFoundException{
      File file = new File(filename);
      Scanner input = new Scanner (file);
      int n = input.nextInt();

      ArrayList<Person> PersonList = new ArrayList<>();
      
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
         if(!(candidate.getHeight() > 0)){
            personList.remove(i);
            i -= 1;
         }

      } //close for loop
   } //close method


   public static void sortWeight(ArrayList<Person> personList){
      int minIndex;
      int n = personList.size();

      for(int i = 0; i < n - 1; i++){ //one by one moving last element of unsorted subarray
         minIndex = i; //finding the minimum element in the unsorted array.
         for(int j = i + 1; j < n; j++){
            int currentMinWeight = personList.get(minIndex).getWeight();
            int weight_j = personList.get(j).getWeight();
            if(weight_j > currentMinWeight){
               minIndex = j; //search for the lowest index.
            }
            //Swap minimum element and put it in the first position.
         }
         if(minIndex != i){
            Person tempPerson = personList.get(i);
            personList.set(i, personList.get(minIndex)); //put first
            personList.set(minIndex, tempPerson); //replace with temp
         }
      }
      //return personList;
   }

   public static void sortWeightAscending(ArrayList<Person> personList){
      int maxIndex;
      int n = personList.size();

      for(int i = 0; i < n - 1; i++){ //one by one moving last element of unsorted subarray
         maxIndex = i; //get max value
         for(int j = i + 1; j < n; j++){
            int currentMinWeight = personList.get(maxIndex).getWeight();
            int weight_j = personList.get(j).getWeight();
            if(weight_j < currentMinWeight){
               maxIndex = j; //search for the lowest index.
            }
            //Swap minimum element and put it in the first position.
         }
         if(maxIndex != i){
            Person tempPerson = personList.get(i);
            personList.set(i, personList.get(maxIndex)); //put first
            personList.set(maxIndex, tempPerson); //replace with temp
         }
      }
      //return personList;
   }




   public static void averageBMI(ArrayList<Person> personList) {

      int[] bmi = new int[6];
      int[] count = new int[bmi.length];

      for (Person person : personList) {
         int age = person.getAge();
         double bmiValue = person.getWeight() / Math.pow(((double) person.getHeight() / 100), 2); //BMI rounded to 2 decimals (only for output legibility)
         for (int k = 0; k < bmi.length; k++) {
            int lowerBound = 10 * (k + 2);
            int upperBound = 10 * (k + 3);
            if (age >= lowerBound && age < upperBound) {
               bmi[k] += bmiValue;
               count[k]++;
            }
         }
      }
      for(int l = 0; l < bmi.length; l++){
         if(count[l] != 0){
            double averageBMI = bmi[l]/(double)count[l];
            double avgRoundedBMI = (double) Math.round(averageBMI * 100) / 100;
            int lowerBound = 10*(l+2);
            int upperBound = 10*(l+3) - 1;
            System.out.println("There were " + count[l] + " persons in the age group of " + lowerBound + "-" + upperBound + " with an average BMI of: " + avgRoundedBMI );
         }
      }
   } //close method


} //close class




