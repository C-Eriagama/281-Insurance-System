// Profile class with name and age
package nz.ac.auckland.se281;

public class Profile {

  // Instance Fields
  private String name;
  private int age;

  // Profile Constructor
  public Profile(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getFirstName() {
    return name;
  }

  public int getAge() {
    return age;
  }
}
