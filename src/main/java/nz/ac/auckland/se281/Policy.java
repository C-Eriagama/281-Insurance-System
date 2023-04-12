package nz.ac.auckland.se281;

public abstract class Policy {
  protected int sum;
  protected int basePremium;

  public enum Type {
    HOME,
    CAR,
    LIFE
  }

  public Policy(int sum) {
    this.sum = sum;
  }

  public void setBasePremium(int basePremium) {
    this.basePremium = basePremium;
  }

  public int getBasePremium() {
    return basePremium;
  }

  public int getSum() {
    return sum;
  }

  public abstract Policy.Type getType();
}
