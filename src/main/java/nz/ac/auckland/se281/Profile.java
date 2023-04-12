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

  public void addPolicy(Policy policy) {
    policies.add(policy);
  }

  public int totalPolicies() {
    return policies.size();
  }

  public ArrayList<Policy> getPolicies() {
    return policies;
  }

  public Policy getPolicy(int index) {
    return policies.get(index);
  }

  public boolean alreadyLifePolicy() {
    for (Policy policy : policies) {
      if (policy.getType() == Policy.Type.LIFE) {
        return true;
      }
    }
    return false;
  }

  public void printPolicies() {

    for (Policy policy : policies) {

      Policy.Type type = policy.getType();
      String sum = Integer.toString(policy.getSum());
      String premium = Integer.toString(policy.getBasePremium());

      switch (type) {
        case HOME:
          String address = ((HomePolicy) policy).getAddress();
          MessageCli.PRINT_DB_HOME_POLICY.printMessage(address, sum, premium, "0");

        case CAR:
          String makeModel = ((CarPolicy) policy).getMake() + " " + ((CarPolicy) policy).getModel();
          MessageCli.PRINT_DB_CAR_POLICY.printMessage(makeModel, sum, premium, "0");
          break;

        case LIFE:
          MessageCli.PRINT_DB_LIFE_POLICY.printMessage(sum, premium, "0");
          break;

        default:
          break;
      }
    }
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
