/* File: Person.java
 *  Author: Andre Berger
 *   
 *  Implements several methods for the class Person.
 */
  
public class Person { 
  
  private String firstName;
  private String lastName;
  private int age;
  private int height;
  
  // creates a person instance with the given arguments
  public Person(String firstName, String lastName, int age, int height){
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.height = height;
  }
  
  // returns the first name of this person as a String
  public String getFirstName(){
    return this.firstName; 
  }
    
    
  // returns the last name of this person as a String
  public String getLastName(){
    return this.lastName; 
  }
    
  // returns a string representation of a person
  public String toString(){
    return (this.firstName + " " +  this.lastName + ", age: " + this.age + ", height: " + this.height + " cm");
  }
  
  // sets the height of this person to the value of the argument  
  public void setHeight(int h){
    this.height = h;
  }
  
  // sets the age of this person to the value of the argument
  public void setAge(int a){
    this.age = a;
  }

  // returns true if this person is older than secondPerson 
  public boolean isOlder(Person secondPerson){   
    return (this.age > secondPerson.age);    
  }
  
  // returns true if this person is taller than secondPerson 
  public boolean isTaller(Person secondPerson){   
    return (this.height > secondPerson.height);    
  }
  
}
