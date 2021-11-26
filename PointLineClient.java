/* File:  PointLineClient.java
Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)
 * Tests several methods for the classes Point and Line
 */


 
public class PointLineClient{
  
  public static void main(String args[]){
    
    Point p = new Point(1,1);    
    Point q = new Point(4,2);
    
    System.out.println("Point p: " + p);
    System.out.println("Point q: " + q);
    
    Line g = new Line (p,q);
    Line f = new Line (-1,1);
    
    System.out.println("Line g: " + g);
    System.out.println("Line f: " + f);
    
    System.out.println("Are the lines " + f + " and " + g + " parallel? " + f.isParallel(g));
    
    System.out.println("root of line " +  f + " is " + f.root());
    System.out.println("root of line " +  g + " is " + g.root());
    
    System.out.println("Does line f contain p? " + f.containsPoint(p));
    System.out.println("Does line g contain q? " + g.containsPoint(p));
    
    
    System.out.println("Does point p lie on line f? " + p.isOnLine(f));
    System.out.println("Does point q lie on line g? " + q.isOnLine(g));
    
    System.out.println("f and g intersect in point " + f.intersection(g));
  }
}


