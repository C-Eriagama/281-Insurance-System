package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
    // ArrayList database = new ArrayList();
  }

  public void printDatabase() {
    // TODO: Complete this method.
  }

  public void createNewProfile(String userName, String age) {

    // Initialise variables to error check and help formatting
    int nameLength = userName.length();
    String firstLetter = "" + userName.charAt(0);
    int years = Integer.parseInt(age);

    userName = firstLetter.toUpperCase() + userName.substring(1, nameLength).toLowerCase();

    if (years < 0) {
      MessageCli.INVALID_AGE.printMessage(age, userName);
    }

    if (nameLength < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
    }
  }

  public void loadProfile(String userName) {
    // TODO: Complete this method.
  }

  public void unloadProfile() {
    // TODO: Complete this method.
  }

  public void deleteProfile(String userName) {
    // TODO: Complete this method.
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
