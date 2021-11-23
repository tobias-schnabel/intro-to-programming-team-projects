/* File:  Date.java
 *  Authors:    Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)
 *
 *  Implements several methods for the class Date.
 */

public class Date{

   public int day;
   public int month;
   public int year;

  // constructor that initializes a date object with a fixed date (1.1.1900)
   public Date (){
    this.day = 1;
    this.month = 1;
    this.year = 1990;
   } //close constructor


   // constructor that initializes a date object with the given arguments
   public Date (int day, int month, int year){
    this.day = day;
    this.month = month;
    this.year = year;
   }

   // displays this date on the screen
   public String toString(){
    return (this.day + "." + this.month + "." + this.year +"\n");

   }

   // method that  returns true if this date is equal to the date given by the argument date
   public boolean isEqual(Date date){
    return this.day == date.day
            && this.month == date.month
            && this.year == date.year;
   }

   // method that  returns true if this date is before  the date given by the argument
   public boolean isBefore(Date date){
   return this.day <= date.day
           && this.month <= date.month
           && this.year <= date.year;
   }

   // method that increments this date by one day
   public void increment() {
    if (this.month == 2  && this.day < 28 && !this.isLeapYear()) { //special case february before 28th
     this.day += 1;
    } else if(this.month == 2 && this.day < 29 && this.isLeapYear()){
     this.day+=1;
    } else if(this.month == 2 && !this.isLeapYear() && this.day == 28){
     this.day-=27;
     this.month+=1;
    } else if (this.month == 2 && this.isLeapYear() && this.day == 29) {
    this.day-=28;
    this.month+=1;
    } else if (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 //case for months of 31 days
            || this.month == 8 || this.month == 10 || this.month == 12) {
     if (this.day <= 30) {
      this.day += 1;
     } else if (this.day == 31 && this.month != 12) {
      this.day -= 30;
      this.month += 1;
     }
    } else if (this.month == 4 || this.month == 6 || this.month == 9 //case for months of 30 days
            || this.month == 11) {
     if (this.day <= 29) {
      this.day += 1;
     } else if (this.day == 30) {
      this.day -= 29;
      this.month += 1;
     }
    } else if (this.month == 12 && this.day == 31) {  //special case last day of year
     this.day -= 30;
     this.month -= 11;
     this.year += 1;
    }
   } //close method

   // method that returns true if the year of this date is a leap year
   private boolean isLeapYear(){

      if (this.year % 4 == 0 && this.year % 100 == 0 && this.year %400 != 0) { //leap years are divisible by 4 and 100, not divisible by 400
       return true;
      } else {
       return false;
      }
       } //close method

}