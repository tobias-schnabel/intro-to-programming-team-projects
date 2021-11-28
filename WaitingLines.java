/* File: WaitingLines.java
 * Author: Andre Berger  
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
  
   // test the simulation using command line parameters for M, T, K and D
   public static void main (String[] args){
   
      int M  = Integer.parseInt(args[0]);
      int T  = Integer.parseInt(args[1]);
      int K  = Integer.parseInt(args[2]);
      int D  = Integer.parseInt(args[3]);
      
      WaitingLines waitingLines = new WaitingLines(M, T, K, D);
   
      waitingLines.run();
   
      System.out.println("Average wait time per customer: " + waitingLines.getAverageWaitTime());
      System.out.println("Average queue length: " + waitingLines.getAverageQueueLength()); 
   }

   // returns the average wait time of customers that have been served
   public double getAverageWaitTime(){
    
    // change this
    return 0;
   }
   
   // returns the average queue length over the time period
   public double getAverageQueueLength(){  
 
    // change this
    return 0;
   }
  
   // runs the simulation as described in the exercise
   public void run(){
    
   }
 


}

