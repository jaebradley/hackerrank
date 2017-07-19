package algorithms.implementations;

import algorithms.interfaces.BetweenTwoSets;
import algorithms.interfaces.GreatestCommonDivisorCalculator;
import algorithms.interfaces.LeastCommonMultipleCalculator;

import java.util.Set;

public class BetweenTwoSetsImpl implements BetweenTwoSets {
  private final GreatestCommonDivisorCalculator gcdCalculator;
  private final LeastCommonMultipleCalculator lcmCalculator;

  public BetweenTwoSetsImpl(final GreatestCommonDivisorCalculator gcdCalculator, final LeastCommonMultipleCalculator lcmCalculator) {
    this.gcdCalculator = gcdCalculator;
    this.lcmCalculator = lcmCalculator;
  }

  @Override
  public int betweenValuesCount(final Set<Long> firstValues, final Set<Long> secondValues) {
    if (firstValues.size() < 2 || secondValues.size() < 2) {
      return 0;
    }

    final long gcd = this.gcdCalculator.calculateGreatestCommonDivisor(secondValues);
    final long lcm = this.lcmCalculator.calculateLeastCommonMultiple(firstValues);

    int count = 0;
    long lcmMultiple = lcm;
    while (lcmMultiple <= gcd) {
      if (gcd % lcmMultiple == 0) {
        count++;
      }
      lcmMultiple += lcm;
    }

    return count;
  }
}
