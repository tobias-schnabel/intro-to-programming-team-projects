/* File: Person.java
 Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)

 *  Implements several methods for the class Person.
 */
  
public class Person { 
  
  private String firstName;
  private String lastName;
  private int age;
  private int height;
  private int weight; // instance var weight
  
  // creates a person instance with the given arguments
  public Person(String firstName, String lastName, int age, int height){
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.height = height;
  }

  // second (overloaded) constructor with additional weight arg
  public Person(String firstName, String lastName, int age, int height, int weight){
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }
  
  // returns the first name of this person as a String
  public String getFirstName(){
    return this.firstName; 
  }
    
    
  // returns the last name of this person as a String
  public String getLastName(){
    return this.lastName; 
  }

  // getter weight
  public int getWeight() {return this.weight; }

  //getter age
  public int getAge() {return this.age; }

  //getter Height
  public int getHeight() {return this.height; }
    
  // returns a string representation of a person
  public String toString(){
    return (this.firstName + " " +  this.lastName + ", age: " + this.age + ", height: " + this.height + " cm");
  }
  
  // sets the height of this person to the value of the argument  
  public void setHeight(int h){
    this.height = h;
  }

  //setter weight
  public void setWeight(int w) {this.weight = w; }
  
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

  //BMI method
  public double bmi() {return ((this.weight / Math.pow(this.height, 2))*10000); } //10 000 accounts for weight being kg and height in cm
  
}
