package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  ArrayList<Profile> database = new ArrayList<Profile>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {

    int profileCount = database.size();

    // Print Number of profiles created
    if (profileCount == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
      return;
    } else if (profileCount == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", "", ":");
    } else {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(Integer.toString(profileCount), "s", ":");
    }

    // Print each profile
    for (int i = 0; i < profileCount; i++) {

      Profile temp = database.get(i);
      String name = temp.getFirstName();
      String age = Integer.toString(temp.getAge());

      MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(Integer.toString(i + 1), name, age);
    }
  }

  public void createNewProfile(String userName, String age) {

    // Initialise variables to error check and help formatting
    int years = Integer.parseInt(age);
    userName = toTitleCase(userName);
    int nameLength = userName.length();

    // Check for any errors with input

    // Check if age is below 0
    if (years < 0) {
      MessageCli.INVALID_AGE.printMessage(age, userName);
      return;
    }

    // Check if name is too short
    if (nameLength < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
      return;
    }

    // Check if username already exists
    for (int i = 0; i < database.size(); i++) {
      Profile temp = database.get(i);
      if (temp.getFirstName() == userName) {
        MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
        return;
      }
    }

    // Add profile to database
    database.add(new Profile(userName, years));
    MessageCli.PROFILE_CREATED.printMessage(userName, age);

    return;
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

  // method to convert string to titlecase
  public String toTitleCase(String text) {
    int nameLength = text.length();
    String firstLetter = "" + text.charAt(0);
    text = firstLetter.toUpperCase() + text.substring(1, nameLength).toLowerCase();
    return text;
  }
}
