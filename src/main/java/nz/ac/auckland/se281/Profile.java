package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Profile {

  // Instance Fields
  private String name;
  private int age;
  private boolean loaded;

  ArrayList<Policy> policies = new ArrayList<Policy>();

  // Profile Constructor
  public Profile(String name, int age) {
    this.name = name;
    this.age = age;
    loaded = false;
  }

  public String getFirstName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public boolean getLoaded() {
    return loaded;
  }

  public void setloaded(boolean value) {
    loaded = value;
    return;
  }
}
