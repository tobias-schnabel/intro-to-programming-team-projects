/* File: IntegerStack.java
 * Author: Andre Berger  
 *
 * Class that provides basic operations for
 * a stack data structure for integers
 */
 
public class IntegerStack{
   
   private int size;          // size of the stack
   private Node first;     // top of stack
   
   
   // helper linked list class
   private class Node {
      private int value;
      private Node next;
   }
   
   // Constructor for an empty stack
   
   public IntegerStack() {
      this.first = null;
      this.size = 0;
   }
   
   // Returns true if this stack is empty.
   
   public boolean isEmpty() {
      return first == null;
   }
   
   // returns the size of this stack
   public int size() {
      return this.size;
   }
   
   // adds number to the top of the stack
   public void push(int number) {
      Node oldfirst = first;
      first = new Node();
      first.value = number;
      first.next = oldfirst;
      size++;
   }
   
   public String toString(){
      
      IntegerStack aux = new IntegerStack();
      
      String stackString = new String();
      
      while(!this.isEmpty()){
         int x = this.pop();
         stackString += x +" ";
         aux.push(x);
      }
      
      while(!aux.isEmpty()){
         this.push(aux.pop());
      }
      
      stackString += "\n";
      return stackString;
   }
   /**
    * Removes and returns the item most recently added to this stack.
    *
    */
   public int pop() {
      // if (isEmpty()) throw new NoSuchElementException("Stack underflow");
      int  number = first.value;        // save item to return
      first = first.next;            // delete first node
      size--;
      return number;                   // return the saved item
   }
   
   // applies the absolute value function to
   // each integer in the stack
   public void absoluteValue(){
    
      IntegerStack aux = new IntegerStack();
    
      // move this stack to auxiliary stack and apply absolute value
      while(!this.isEmpty()){
         aux.push(Math.abs(this.pop()));             
      }
    
      // put auxiliary stack back on original stack     
      while(!aux.isEmpty()){
         this.push(aux.pop());
      }
    
   }

   public boolean isEqual(IntegerStack secondStack) {
      return true; //stub
   }
   
} //close class
  
