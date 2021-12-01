/* File: Customer.java
 * Authors: Authors: Dohmen, RJH (i6250494)
           Schnabel, CT (i6255807)
 *
 * Data structure for customers with arrival and service times  
 */
 
public class Customer{
  
  private final int arrivalTime;
  private final int serviceTime;
  
  // constructs a task with arrival time a and duration d
  public Customer (int arrivalTime, int serviceTime){
    this.arrivalTime = arrivalTime;
    this.serviceTime = serviceTime;
  }
  
  // returns the arrival time of this customer
  public int getArrivalTime(){
    return this.arrivalTime; 
  }
  
  // returns the service time of this customer
  public int getServiceTime(){
    return this.serviceTime; 
  }
  
}