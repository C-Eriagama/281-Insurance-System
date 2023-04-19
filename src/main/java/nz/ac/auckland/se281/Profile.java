package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Profile {

  // Instance Fields
  private String name;
  private int age;
  private boolean loaded;

  ArrayList<Policy> policies = new ArrayList<Policy>();
  private double discount = 1;

  // Profile Constructor
  public Profile(String name, int age) {
    this.name = name;
    this.age = age;
    loaded = false;
  }

  // Policy methods

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

  // Update the discount value
  public void setDiscount() {

    if (policies.size() == 2) {
      this.discount = 0.9;
    } else if (policies.size() >= 3) {
      this.discount = 0.8;
    } else {
      this.discount = 1;
    }

    return;
  }

  // Calculate the total premium as a sum of discounted premiums
  public int calculateTotalPremium() {

    int totalPremium = 0;

    for (Policy policy : policies) {
      totalPremium += (int) ((double) (policy.getBasePremium()) * this.discount);
    }

    return totalPremium;
  }

  // Check if the profile has a life policy
  public boolean alreadyLifePolicy() {
    for (Policy policy : policies) {
      if (policy.getType() == Policy.Type.LIFE) {
        return true;
      }
    }
    return false;
  }

  // Print all the policies for a profile
  public void printPolicies() {

    for (Policy policy : policies) {

      Policy.Type type = policy.getType();
      String sum = Integer.toString(policy.getSum());
      String premium = Integer.toString(policy.getBasePremium());
      String discountPremium =
          Integer.toString((int) ((double) (policy.getBasePremium()) * this.discount));

      switch (type) {
        case HOME:
          String address = ((HomePolicy) policy).getAddress();
          MessageCli.PRINT_DB_HOME_POLICY.printMessage(address, sum, premium, discountPremium);
          break;

        case CAR:
          String makeModel = ((CarPolicy) policy).getMake() + " " + ((CarPolicy) policy).getModel();
          MessageCli.PRINT_DB_CAR_POLICY.printMessage(makeModel, sum, premium, discountPremium);
          break;

        case LIFE:
          MessageCli.PRINT_DB_LIFE_POLICY.printMessage(sum, premium, discountPremium);
          break;

        default:
          break;
      }
    }
  }

  // Getters and Setters

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
