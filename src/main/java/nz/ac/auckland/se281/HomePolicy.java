package nz.ac.auckland.se281;

public class HomePolicy extends Policy {

  private String address;
  private boolean rental;
  private int basePremium;

  HomePolicy(int sum, String address, boolean rental) {
    super(sum);
    this.address = address;
    this.rental = rental;
  }

  @Override
  protected int calculateBasePremium() {
    if (rental) {
      return sum / 50;
    } else {
      return sum / 100;
    }
  }

  @Override
  public Policy.Type getType() {
    return Policy.Type.HOME;
  }
}
