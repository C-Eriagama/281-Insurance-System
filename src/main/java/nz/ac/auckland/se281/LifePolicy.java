package nz.ac.auckland.se281;

public class LifePolicy extends Policy {
  LifePolicy(int sum) {
    super(sum);
  }

  public int calculateBasePremium(int age) {
    return (1 + age / 100) / 100;
  }

  @Override
  public Policy.Type getType() {
    return Policy.Type.LIFE;
  }
}
