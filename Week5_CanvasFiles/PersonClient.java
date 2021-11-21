/* File: PersonClient.java
 *  Author: Andre Berger
 *   
 *  Tests several methods for the class Person.
 */
  
  public class PersonClient { 
    
    public static void main(String[] args) { 
      
      // create a new Person instance
      Person andre = new Person("Andre", "Berger", 43, 180);
      System.out.println(andre);
      
      // create another Person instance
      
      Person john = new Person("John", "Doe", 23, 190);
      System.out.println(john);
      
      System.out.println("Is Andre older than John? " + andre.isOlder(john));
      System.out.println("Is Andre taller than John? " + andre.isTaller(john));
      
      // change values
      andre.setHeight(200);
      andre.setAge(20);
      
      System.out.println(andre);
      System.out.println("Is Andre older than John? " + andre.isOlder(john));
      System.out.println("Is Andre taller than John? " + andre.isTaller(john));
      System.out.println("----------------------------------");
   
      /* Disclaimer: the code below shows how the declaration of variables
       * of type Person can lead to undesired behavior. Try to understand
       * what happens here and why. 
       * 
       * The program outputs each time the information about three variables of
       * type person. Only two Person instances have been created above, thus
       * at least two of the output lines have to be the same.
       * 
       */

      Person thomas = andre;    
      
      thomas.setAge(50);
      
      System.out.println(andre);
      System.out.println(thomas);
      System.out.println(john);
      
      System.out.println("----------------------------------");
      
      andre = john;
      andre.setAge(39);
      
      System.out.println(andre);
      System.out.println(thomas);
      System.out.println(john);
  
    }
  }
 
  