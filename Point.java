/* File:  Point.java
Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)
 *  Implements several methods for the class Point.
 */
 


public class Point { 

   private double x;   
   private double y;   
   
   // constructor for a point, initializes coordinates (0,0) 
   public Point() {
      this.x = 0;
      this.y = 0;
   }
   
   // overloaded constructor for a point with given coordinates (x, y)
   public Point(double x, double y) {
    this.x = x;
    this.y = y;
   }
   // returns the x coordinate of a point
   public double getX(){
     return this.x;
   }
    
   // returns the y coordinate of a point
   public double getY(){
    return this.y;
   }
   
   // returns true if this point is on the line given by the parameter g
   public boolean isOnLine (Line g){
      return (this.getY() == g.getIntercept() + g.getSlope() * this.getX());
   }
   
   // return string representation of this point
   public String toString() {

     return "(" + x + ", " + y + ")";

   }    
}



