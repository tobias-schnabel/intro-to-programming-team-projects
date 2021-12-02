/* File: WaitingLines.java
 *Authors: Dohmen, RJH (i6250494)
           Schnabel, CT (i6255807)
 *
 * Class that simulates a waiting line system 
 */

import java.util.Scanner;

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

   // test the simulation using (command line) parameters for M, T, K and D
   public static void main(String[] args) {

      //get user input
      Scanner in = new Scanner(System.in);
      System.out.println("Please enter the time horizon in minutes (T): "); //600
      int T = in.nextInt();
      System.out.println("Please enter the maximum number of customers arriving at a time (K): "); //5
      int K = in.nextInt();
      System.out.println("Please enter the maximum service time per customer (D): "); //3
      int D = in.nextInt();
      System.out.println("Please enter the maximum number of cashiers (M > 1):"); //5
      int M = in.nextInt();
      in.close();
      System.out.println("\n");


      for (int m = 1; m <= M; m++){
         WaitingLines waitingLines = new WaitingLines(m, T, K, D); //instantiate
         waitingLines.run(); //execute
         System.out.println("Simulation results for M = " + m + " cashiers: ");
         System.out.println("Average wait time: " + Math.round(waitingLines.getAverageWaitTime()) + " minutes per customer");
         System.out.println("Average queue length: " + Math.round(waitingLines.getAverageQueueLength()) +"\n");
         System.out.println("**********************************************\n");
      }


   }

   // returns the average wait time of customers that have been served
   public double getAverageWaitTime() {

      return (double) (this.totalWaitTime) / (double) (this.totalNumberOfCustomers);
   }

   // returns the average queue length over the time period
   public double getAverageQueueLength() {

      return (double) (this.finalQueueLength) / (double) (this.numberOfTimePeriods);
   }

   // runs the simulation as described in the exercise
   public void run() {
      //instantiate queue
      Queue<Customer> customerQueue = new Queue<>();

      //create integer array of length M, equal to the number of cashiers
      // where the ith entry of the array represents the time that cashier i becomes available again.
      int[] availability = new int[this.numberOfCashiers];

      //iterate for each time period up until T
      for (int t = 0; t <= this.numberOfTimePeriods; t++) {
         //generates a random # between 1 and maxNumberOfCustomers
         int arrivingCustomers = 1 + (int) (Math.random() * 2)  * (this.maxNumberOfCustomers);
         this.totalNumberOfCustomers += arrivingCustomers;  //update total # of customers

         //assigns service time for each customer and adds customers to the queue
         for (int i = 0; i < arrivingCustomers; i++) {
            //generates a random # between 1 and maxServiceTime
            int serviceTime = 1 + (int) (Math.random() * 2) * (this.maxServiceTime);
            Customer customer = new Customer(t, serviceTime);
            customerQueue.enqueue(customer);
         }// close for loop

         for (int j = 0; j < this.numberOfCashiers; j++) {
            //dequeues a customer in case queue is non-empty and a cashier is available
            if (!customerQueue.isEmpty() && availability[j] == 0) {
               Customer nextCustomer = customerQueue.dequeue();
               availability[j] = nextCustomer.getServiceTime();
               this.totalWaitTime += t - nextCustomer.getArrivalTime(); //update totalWaitTime
            }// close if statement
         }//close for loop

         //update total queue length
         this.totalQueueLength += customerQueue.size();

         //subtracts the passed time (1) from each cashier's
         //service time in case it is larger than 0
         for (int k = 0; k < this.numberOfCashiers; k++) {
            if (availability[k] > 0) {
               availability[k]--;
            }//close if statement

         }//close for loop

      }//close outer loop
      this.finalQueueLength = this.totalQueueLength;
   }//close method
}//close class

