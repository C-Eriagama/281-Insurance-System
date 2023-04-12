package nz.ac.auckland.se281;

public class HomePolicy extends Policy {

  private String address;
  private boolean rental;

  HomePolicy(int sum, String address, boolean rental) {
    super(sum);
    this.address = address;
    this.rental = rental;
  }

  public int calculateBasePremium() {
    if (rental) {
      return (int) (sum * 0.02);
    } else {
      return (int) (sum * 0.01);
    }
  }

  public String getAddress() {
    return address;
  }

  @Override
  public Policy.Type getType() {
    return Policy.Type.HOME;
  }
}
