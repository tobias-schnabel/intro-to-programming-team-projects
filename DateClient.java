/* File: DateClient.java
 * Author: Andre Berger
 *
 *  Tests methods for the class Date.
 */

public class DateClient{

  public static void main(String[] args){

    Date begin = new Date(1,1,2020);
    Date end = new Date(31,12,2020);

    // insert code to display all dates from "begin" to "end" on the screen
    if (!begin.isBefore(end)){
      System.out.println("Please enter a Begin date before the End date.");
      return;
    }
    while (!begin.isEqual(end)) {
      System.out.print(begin);
      begin.increment();
      }
    System.out.print(end);
  }

}