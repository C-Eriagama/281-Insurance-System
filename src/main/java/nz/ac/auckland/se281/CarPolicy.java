package nz.ac.auckland.se281;

public class CarPolicy extends Policy {

  private String make;
  private String model;
  private String licensePlate;
  private boolean mechanicalBreakdown;

  // CarPolicy constructor
  CarPolicy(int sum, String make, String model, String licensePlate, boolean mechanicalBreakdown) {
    super(sum);
    this.make = make;
    this.model = model;
    this.licensePlate = licensePlate;
    this.mechanicalBreakdown = mechanicalBreakdown;
  }

  public int calculateBasePremium(int age) {
    int premium;

    // adjust premium based on age and mechanical breakdown
    if (age < 25) {
      premium = (int) (sum * 0.15);
    } else {
      premium = (int) (sum * 0.10);
    }

    if (mechanicalBreakdown) {
      premium += 80;
    }

    return premium;
  }

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public String getLicensePlate() {
    return licensePlate;
  }

  @Override
  public Policy.Type getType() {
    return Policy.Type.CAR;
  }
}
