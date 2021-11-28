/* File: IntegerStackClient3.java
 * Author: Andre Berger  
 *
 * Class that tests the reverse method for IntegerStacks
 */

public class IntegerStackClient3{
   
   public static void main (String[] args){
      
      IntegerStack myStack = new IntegerStack(); 
      
      // add 10 random integers to the stack
      for(int i=0; i<10; i++){
         myStack.push((int) (Math.random()*20)); 
      }
      
      System.out.println("Stack looks like this: "+ myStack);    
      myStack.reverse();
      System.out.println("After reversal, stack looks like this: "+ myStack);
   }
}