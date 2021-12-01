/* File: WaitingLines.java
 *Authors: Dohmen, RJH (i6250494)
           Schnabel, CT (i6255807)
 *
 * Class that simulates a waiting line system 
 */
 

import java.util.*;

public class WaitingLines{
  
   private final int numberOfCashiers;
   private final int numberOfTimePeriods;
   private final int maxNumberOfCustomers;
   private final int maxServiceTime;
  
   private int totalQueueLength;
   private int totalWaitTime;
   private int totalNumberOfCustomers;
   private int finalQueueLength;
   
   public WaitingLines(int numberOfCashiers, int numberOfTimePeriods, int numberOfCustomers, int serviceTime){
    
      this.numberOfCashiers = numberOfCashiers;
      this.numberOfTimePeriods = numberOfTimePeriods;
      this.maxNumberOfCustomers = numberOfCustomers;
      this.maxServiceTime = serviceTime;
    
      this.totalQueueLength = 0;
      this.totalWaitTime = 0;
      this.totalNumberOfCustomers = 0;
   }

   public int getTotalQueueLength(){
      return this.totalQueueLength;
   }

   public int getTotalWaitTime(){
      return this.totalWaitTime;
   }

   public int getTotalNumberOfCustomers(){
      return this.totalNumberOfCustomers;
   }

   public void setTotalQueueLength(int queueLength){
      this.totalQueueLength = queueLength;
   }

   public void setTotalWaitTime(int waitTime){
      //updates totalWaitTime instead of replacing value
      this.totalWaitTime = this.totalWaitTime + waitTime;
   }

   public void setTotalNumberOfCustomers(int numberOfCustomers){
      //updates totalNumberOfCustomers instead of replacing value
      this.totalNumberOfCustomers = this.totalNumberOfCustomers + numberOfCustomers;
   }
  
   // test the simulation using (command line) parameters for M, T, K and D
   public static void main (String[] args){
   
      int M  = 5; //try different values
      int T  = 600; // T = 600 for testing
      int K  = 5; // K = 5 for testing
      int D  = 3; // D = 3 for testing
      
      WaitingLines waitingLines = new WaitingLines(M, T, K, D);
   
      waitingLines.run();
   
      System.out.println("Average wait time per customer: " + waitingLines.getAverageWaitTime());
      System.out.println("Average queue length: " + waitingLines.getAverageQueueLength()); 
   }

   // returns the average wait time of customers that have been served
   public double getAverageWaitTime(){

    double avgWaitTime = this.getTotalWaitTime() / this.getTotalNumberOfCustomers();
    // change this
    return avgWaitTime;
   }
   
   // returns the average queue length over the time period
   public double getAverageQueueLength(){

      double avgQueueLength = 0;
    // change this
    return avgQueueLength;
   }
  
   // runs the simulation as described in the exercise
   public void run(){

      //create integer array of length M,
      // where the ith entry of the array represents the time that cashier i becomes available again.
      int[] availability= new int[this.numberOfCashiers];   //init array

      for(int i = 0; i < this.numberOfCashiers; i++){
         availability[i] = 1; //time until cashier available given?
      }

      for(int i = 0; i < this.numberOfTimePeriods; i++){ //iterate time periods up until T
        int arrivingCustomers = 1 + (int)(Math.random()) * (this.maxNumberOfCustomers);

        //for(int j = 0; j  < arrivingCustomers;  j++){

        }

      }
   }
 


}

