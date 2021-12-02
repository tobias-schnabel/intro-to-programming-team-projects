/* File: WaitingLines.java
 *Authors: Dohmen, RJH (i6250494)
           Schnabel, CT (i6255807)
 *
 * Class that simulates a waiting line system 
 */
 

import java.util.*;

public class WaitingLines {

   private final int numberOfCashiers;
   private final int numberOfTimePeriods;
   private final int maxNumberOfCustomers;
   private final int maxServiceTime;

   private int totalQueueLength;
   private int totalWaitTime;
   private int totalNumberOfCustomers;
   private int finalQueueLength;

   public WaitingLines(int numberOfCashiers, int numberOfTimePeriods, int numberOfCustomers, int serviceTime) {

      this.numberOfCashiers = numberOfCashiers;
      this.numberOfTimePeriods = numberOfTimePeriods;
      this.maxNumberOfCustomers = numberOfCustomers;
      this.maxServiceTime = serviceTime;

      this.totalQueueLength = 0;
      this.totalWaitTime = 0;
      this.totalNumberOfCustomers = 0;
   }

   public int getTotalQueueLength() {
      return this.totalQueueLength;
   }

   public int getTotalWaitTime() {
      return this.totalWaitTime;
   }

   public int getTotalNumberOfCustomers() {
      return this.totalNumberOfCustomers;
   }

   public void setTotalQueueLength(int queueLength) {
      this.totalQueueLength = this.totalQueueLength + queueLength;
   }

   public void setTotalWaitTime(int waitTime) {
      //updates totalWaitTime instead of replacing value
      this.totalWaitTime += waitTime;
   }

   public void setTotalNumberOfCustomers(int numberOfCustomers) {
      //updates totalNumberOfCustomers instead of replacing value
      this.totalNumberOfCustomers = this.totalNumberOfCustomers + numberOfCustomers;
   }

   // test the simulation using (command line) parameters for M, T, K and D
   public static void main(String[] args) {

      int M = 5; //try different values
      int T = 6; // T = 600 for testing
      int K = 5; // K = 5 for testing
      int D = 3; // D = 3 for testing

      WaitingLines waitingLines = new WaitingLines(M, T, K, D);

      waitingLines.run();

      System.out.println("Average wait time per customer: " + waitingLines.getAverageWaitTime());
      System.out.println("Average queue length: " + waitingLines.getAverageQueueLength());
   }

   // returns the average wait time of customers that have been served
   public double getAverageWaitTime() {

      // change this
      return (double) this.getTotalWaitTime() / (double) this.getTotalNumberOfCustomers();
   }

   // returns the average queue length over the time period
   public double getAverageQueueLength() {

      double avgQueueLength = 0;
      // change this
      return avgQueueLength;
   }

   // runs the simulation as described in the exercise
   public void run() {
      //instantiate queue
      Queue<Customer> customerQueue = new Queue<Customer>();
      //create integer array of length M,
      // where the ith entry of the array represents the time that cashier i becomes available again.
      int[] availability = new int[this.numberOfCashiers];   //init array


      //iterate over periods
      for (int t = 0; t < this.numberOfTimePeriods; t++) { //iterate time periods up until T
         //get # arr cusotmers
         int arrivingCustomers = 1 + (int) (Math.random()*2) * (this.maxNumberOfCustomers);
         //instantiate arriving customers
         for (int j = 0; j < arrivingCustomers; j++) { //assigns service times & add customers to queue
            int serviceTime = 1 + (int) (Math.random()*2) * (this.maxServiceTime);
            Customer customer = new Customer(t, serviceTime);
            customerQueue.enqueue(customer);
         }

         //check  whether cashier available
         // while (!customerQueue.isEmpty()){
            for(int i : availability){
               if (availability[i] == 0){ //free cashier, so we dequeue
                  Customer arrivingCustomer;
                  arrivingCustomer = customerQueue.dequeue();
                  availability[i] += arrivingCustomer.getServiceTime();
                  setTotalWaitTime(t - (arrivingCustomer.getArrivalTime()));
               }
            }
        // } //close while

         for (int a : availability) {
            if (availability[a] > 0) { availability[a] -= 1; } ; //prep for next iteration
         }

      } // closes loop for time
   } //clsoe method
} //close class
 




