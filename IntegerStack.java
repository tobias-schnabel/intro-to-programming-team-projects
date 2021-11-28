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

      IntegerStack aux = new IntegerStack();
      boolean isEqual = true;
      int size1 = this.size();
      int size2 = secondStack.size();

      //if stacks don't have the same size return false
      if(size1 != size2){  
         isEqual = false; 
      } else while(!this.isEmpty()){ //if elements are equal move element from this stack to aux
        int x = this.pop();
        int y = secondStack.pop();
         if(x == y){
            aux.push(x);
            aux.push(y);
         } else {
            isEqual =  false; //flag false
            aux.push(x); //still push to aux stack (can't restore otherwise)
            aux.push(y);
         }
      } //close loop

      // put auxiliary stack back on original stack     
      while(!aux.isEmpty()){
         secondStack.push(aux.pop()); //last element was of second stack (y)
         this.push(aux.pop()); //second to last was of this (x)
      }

      return isEqual; 
   } //close method

   /*reverse the order of the items on the stack. You may only use variables
    of primitive data types (e.g. int and boolean) as well as one other Queue instance
    as auxiliary storage.*/
   public void reverse(){
      Queue<Integer> auxQ = new Queue<>();
      while (!this.isEmpty()){
         auxQ.enqueue(this.pop());
      }
      while (!auxQ.isEmpty()){
         this.push(auxQ.dequeue());
      }
   } //close method
} //close class
  
