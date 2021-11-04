/* DayOfWeek.java
Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)*/
         
import java.util.Scanner;
import java.lang.Math;

public class DayOfWeekMethods {

	public static void main(String[] args) {
   
      Scanner in = new Scanner(System.in);
   
   System.out.print("Enter a day: ");
      int d = in.nextInt();
      
   System.out.print("Enter a month: ");
      int m = in.nextInt();
      
   System.out.print("Enter a year: ");
      int y = in.nextInt();
      
   //apply formulas
    int Yo = y-(14-m)/12;
    int x = Yo+(Yo/4)-(Yo/100)+(Yo/400);
    int Mo = m+12*((14-m)/12)-2;      
    int Do = (d+x+(31*Mo)/12)%7;
         
         
   //print output
System.out.println(d + "." + m + "." + y + " is day "+ dayofInt(Do) +" of the week");
System.out.println(d + "." + m + "." + y + " is a "+ dayofStr(Do));

} //close main
       
   public static int dayofInt(int Do) {
           
      int DoInt = Do;
      return DoInt;
      } //close method
      
   public static String dayofStr(int Do) {
   

   String dayString; //declare return variable
   dayString = "Null"; //initialize
   //asign return values
   switch (Do) {
    case 0:
      dayString = "Sunday.";
      break;
   case 1:
      dayString = "Monday.";
      break;
    case 2:
      dayString = "Tuesday.";
      break;
   case 3:
      dayString = "Wednesday.";
      break;
    case 4:
      dayString = "Thursday.";
      break;
    case 5:
      dayString = "Friday.";
      break;
   case 6:
      dayString = "Saturday.";
      break;
          }
      return dayString;
} //close method

} //close class