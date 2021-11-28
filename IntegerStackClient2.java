/* File: IntegerStackClient2.java
 * Author: Andre Berger  
 *
 * Class that tests the isEqual method for IntegerStacks
 */

public class IntegerStackClient2{
   
   public static void main (String[] args){
      
      IntegerStack firstStack = new IntegerStack();
      IntegerStack secondStack = new IntegerStack(); 
      IntegerStack thirdStack = new IntegerStack();
   
      firstStack.push(5);   
      firstStack.push(8);
      firstStack.push(3);
   
      secondStack.push(2);
      secondStack.push(8);
      secondStack.push(3); 
   
      thirdStack.push(5);
      thirdStack.push(8);
      thirdStack.push(3);
   
      System.out.println("Does first stack equal second stack? "+ firstStack.isEqual(secondStack));
      System.out.println("Does second stack equal third stack? "+ secondStack.isEqual(thirdStack));
      System.out.println("Does first stack equal third stack? "+ firstStack.isEqual(thirdStack));
   
   }
}