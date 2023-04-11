package nz.ac.auckland.se281;

public class CarPolicy extends Policy {

  private String make;
  private String model;
  private String licensePlate;
  private boolean mechanicalBreakdown;
  private int basePremium = 0;

  CarPolicy(int sum, String make, String model, String licensePlate, boolean mechanicalBreakdown) {
    super(sum);
    this.make = make;
    this.model = model;
    this.licensePlate = licensePlate;
    this.mechanicalBreakdown = mechanicalBreakdown;
  }

  @Override
  protected int calculateBasePremium() {
    calculateBasePremium(sum);
    return basePremium;
  }

  private int calculateBasePremium(int age) {

    if (age < 25) {
      basePremium = (int) (sum * 0.15);
    } else {
      basePremium = (int) (sum * 0.10);
    }

    if (mechanicalBreakdown) {
      basePremium += 80;
    }
    return basePremium;
  }

  @Override
  public Policy.Type getType() {
    return Policy.Type.CAR;
  }
}
