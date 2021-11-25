/* File:  Line.java
 * Author:    Andre Berger
 * 
 * Implements several methods for the class Line.
 */

import java.awt.Point;

public class Line{
   
   private final double slope;
   private final double intercept;
   
   // constructor for a line with given slope and intercept
   public Line(double slope, double intercept){
      this.slope = slope;
      this.intercept = intercept;
   }
   
   // constructor for a line through points p and q
   public Line(Point p, Point q){
     if(p.y == q.y){  // sets slope and intercept to Double.NaN for vertical lines
       this.setSlope(Double.NaN);
       this.setIntercept(Double.NaN);
     }

     else //slope equation given by: (y2-y1)/(x2-x1)
      double slope = (q.y - p.y)/(q.x - p.x);
      this.setSlope(slope);

      // line equation: y1 = slope*x1 + intercept <=> intercept = y1 - slope*x1
      double intercept = p.y - slope*p.x;
      this.setIntercept(intercept);
   }

   // sets the slope of this line
   public void setSlope(double slope){
     this.slope = slope;
   }

   // sets the intercept of this line
   public void setIntercept(double intercept){
     this.intercept = intercept;
   }
   
   // returns the slope of this line
   public double getSlope(){
     return this.slope;
   }
   
   // returns the intercept of this line
   public double getIntercept(){
     return this.intercept;
   }
   
   // returns whether this line and the line g are parallel
   public boolean isParallel(Line g){ // lines are parallel whenever slopes are equal
     return(this.slope == g.slope);
   }
   
   // returns whether this line contains the point p
   public boolean containsPoint(Point p){ // line equation: y1 = slope*x1 + intercept
     return(p.y == this.slope * p.x + this.intercept);
   }
   
   // returns the x-intercept of the line
   // returns Double.NaN if slope = 0
   public double root(){
     if(this.slope == 0){
       return Double.NaN;
      }
     else return (this.intercept/this.slope);
   }  
   
   // returns the intersection point of this line and the line g
   // returns null if lines are parallel
   public Point intersection(Line g){
      Point intersection = new Point(x, y);
      intersection.x = (g.intercept - this.intercept)/(g.slope - this.slope);
      intersection.y = this.slope * intersection.x + this.intercept;
      return intersection;
   }
   
   // return string representation of this line
   public String toString() {
      
     return "y = " + this.slope + " x + " + this.intercept;

   }    
   
}


