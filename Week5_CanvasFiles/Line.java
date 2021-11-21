/* File:  Line.java
 * Author:    Andre Berger
 * 
 * Implements several methods for the class Line.
 */

public class Line{
   
   private final double slope;
   private final double intercept;
   
   // constructor for a line with given slope and intercept
   public Line(double slope, double intercept){
      
   }
   
   // constructor for a line through points p and q
   // sets slope and intercept to Double.NaN for vertical lines
   public Line(Point p, Point q){
      
   }
   
   // returns the slope of this line
   public double getSlope(){

   }
   
   // returns the intercept of this line
   public double getIntercept(){

   }
   
   // returns whether this line and the line g are parallel
   public boolean isParallel(Line g){

   }
   
   // returns whether this line contains the point p
   public boolean containsPoint(Point p){

   }
   
   // returns the x-intercept of the line
   // returns Double.NaN if slope = 0
   public double root(){
     
   }  
   
   // returns the intersection point of this line and the line g
   // returns null if lines are parallel
   public Point intersection(Line g){
      
      
   }
   
   // return string representation of this line
   public String toString() {
      
     return "y = " + this.slope + " x + " + this.intercept;

   }    
   
}


