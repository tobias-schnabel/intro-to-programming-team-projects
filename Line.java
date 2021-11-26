/* File:  Line.java
 Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)
 * Implements several methods for the class Line.
 */
public class Line{
   
   private final double slope;
   private final double intercept;
   
   // constructor for a line with given slope and intercept
   public Line(double slope, double intercept){
      this.slope = slope;
      this.intercept = intercept;
   } //close constructor
   
   // constructor for a line through points p and q
   public Line(Point p, Point q){
     if(p.getY() == q.getY()){  // sets slope and intercept to Double.NaN for vertical lines
       this.slope = Double.NaN;
       this.intercept = Double.NaN;
     }  else {//slope equation given by: (y2-y1)/(x2-x1)
         this.slope = (q.getY() - p.getY()) / (q.getX() - p.getX());
         // line equation: y1 = slope*x1 + intercept <=> intercept = y1 - slope*x1
         this.intercept =  p.getY() - this.slope*p.getX();
     }

   } //close method

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
     return(p.getY() == this.slope * p.getX() + this.intercept);
   }
   
   // returns the x-intercept of the line
   // returns Double.NaN if slope = 0
   public double root(){
     if(this.slope == 0){
       return Double.NaN;
      }
     else return (this.intercept/this.slope);
   }   //close method
   
   // returns the intersection point of this line and the line g
   // returns null if lines are parallel
   public Point intersection(Line g){
       if (this.isParallel(g)) { return null; }
       else {
           double intersX = (g.intercept - this.intercept)/(g.slope - this.slope);
           double intersY = (this.slope * intersX + this.intercept);
           return new Point(intersX, intersY);
       }
   } //close method
   
   // return string representation of this line
   public String toString() {
     return "y = " + this.slope + " x + " + this.intercept;
   }
} //close class


