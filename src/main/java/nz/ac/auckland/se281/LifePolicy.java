package nz.ac.auckland.se281;

public class LifePolicy extends Policy {

  // LifePolicy constructor
  LifePolicy(int sum) {
    super(sum);
  }

  public int calculateBasePremium(int age) {
    double rate = (1 + (double) age / 100) / 100;
    return (int) ((double) sum * rate);
  }

  @Override
  public Policy.Type getType() {
    return Policy.Type.LIFE;
  }
}
