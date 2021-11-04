
/* StringAddition.java
Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)*/

import java.util.Scanner;

/*develop a method that takes as input two String variables representing
an integer value (you can assume the user makes a valid input). The method
should return the sum of the two values as a String. You should achieve this
 by adding digits one by one as you would do an addition on paper. You are not
 allowed to just convert the whole String into an integer value or to use other
  methods for this that are already provided by Java.
  Then write a program int StringAddition which tests the above method.
 */

/* Methods below assume proper, positive integer input as discussed with tutor */

public class StringAddition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the first number (positive integer):");
        String s1in = in.next(); //first input string

        System.out.println("Enter the second number (positive integer):");
        String s2in = in.next(); //second input string

        String sOut = StringSum(s1in, s2in); //
        System.out.println("The Sum of these two Numbers is " + SumReturn(sOut) + ".");

} //close main


    public static String StringSum(String s1in, String s2in){
        int length1 = s1in.length();
        int length2 = s2in.length();
        int lengthdiff = Math.abs(length1-length2)-1; //get difference in string lengths
        String s1new = "";
        String s2new = "";
        String sOutTemp = ""; //declare and init intermediate return var

        if (length1 > length2) {
            for (int i = 0; i <= lengthdiff; i++) {
                s2new += "0";
            }
            s2new += s2in;
            s1new = s1in;
            }
            else if (length1 < length2) {
            for (int i = 0; i <= lengthdiff; i++) {
                s1new += "0";
            }
            s1new += s1in;
            s2new = s2in;
            } else if (length1 == length2){
                s1new += s1in;
                s2new += s2in;
            }

        int newlength1 = s1new.length();
        int newlength2 = s2new.length();

        int carryOver = 0; //stores value outside loop if sum of string chars is >10
        int remainder;
        if (newlength1 == newlength2) {
            for (int x = (newlength1 -1); x >= 0; x--) {
                int charS1Int = Character.getNumericValue(s1new.charAt(x));
                int charS2Int = Character.getNumericValue(s2new.charAt(x));
                int charsum = charS1Int + charS2Int;
                int sumPlusRemainder = charsum + carryOver;
                if (sumPlusRemainder < 10){
                    sOutTemp += sumPlusRemainder;
                    carryOver = 0;
                } else{
                   remainder = sumPlusRemainder % 10;
                   carryOver =1;
                   sOutTemp += remainder;
                }
                if (x == 0 & carryOver > 0) {
                    sOutTemp += carryOver;
                }
            } //close loop
            } else if (newlength1 != newlength2) { //failsafe to break in case of improper execution
            sOutTemp = "DILAVNI"; //"Invalid" in final output
                }
        return sOutTemp;
    } //close method


    public static String SumReturn(String sOut) {
            String sReturn = ""; //declare and init final return var
            int outlength = sOut.length();
            for (int j = outlength-1; j >= 0; j-- ){
                sReturn += sOut.charAt(j); //mirror sOut because addition was carried out back to front
            }

        return sReturn;

    } //close method
} // close class


