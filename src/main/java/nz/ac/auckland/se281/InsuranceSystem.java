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

      if (temp.getLoaded()) {
        MessageCli.PRINT_DB_PROFILE_HEADER_SHORT.printMessage(
            "*** ", Integer.toString(i + 1), name, age);
      } else {
        MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(Integer.toString(i + 1), name, age);
      }
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

    // Check if username already exists or if profile loaded
    for (int i = 0; i < database.size(); i++) {
      Profile temp = database.get(i);

      if (temp.getFirstName().equals(userName)) {
        MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
        return;
      }

      if (temp.getLoaded()) {
        MessageCli.CANNOT_CREATE_WHILE_LOADED.printMessage(temp.getFirstName());
        return;
      }
    }

    // Add profile to database
    database.add(new Profile(userName, years));
    MessageCli.PROFILE_CREATED.printMessage(userName, age);

    return;
  }

  public void loadProfile(String userName) {
    userName = toTitleCase(userName);

    // find profile and see if profile already loaded
    boolean match = false;
    int profileLoaded = -1;
    int profileToLoad = -1;

    for (int i = 0; i < database.size(); i++) {

      Profile temp = database.get(i);

      if (temp.getLoaded()) {
        profileLoaded = i;
      }

      if (temp.getFirstName().equals(userName)) {
        match = true;
        profileToLoad = i;
      }
    }

    if (!match) {
      MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(userName);
      return;
    }

    if (profileLoaded != -1) {
      database.get(profileLoaded).setloaded(false);
    }

    // load profile
    database.get(profileToLoad).setloaded(true);
    MessageCli.PROFILE_LOADED.printMessage(userName);
  }

  public void unloadProfile() {

    // find profile loaded
    for (int i = 0; i < database.size(); i++) {
      Profile temp = database.get(i);

      if (temp.getLoaded()) {
        database.get(i).setloaded(false);
        MessageCli.PROFILE_UNLOADED.printMessage(temp.getFirstName());
        return;
      }
    }
    MessageCli.NO_PROFILE_LOADED.printMessage();
    return;
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
