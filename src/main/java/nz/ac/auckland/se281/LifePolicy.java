package nz.ac.auckland.se281;

public class LifePolicy extends Policy {
  LifePolicy(int sum) {
    super(sum);
  }

  @Override
  public Policy.Type getType() {
    return Policy.Type.LIFE;
  }
}
