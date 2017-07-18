package algorithms.utilities;

import algorithms.interfaces.GreatestCommonDivisorCalculator;
import algorithms.interfaces.LeastCommonMultipleCalculator;

import java.util.List;

public class LeastCommonMultipleCalculatorImpl implements LeastCommonMultipleCalculator {
  private final GreatestCommonDivisorCalculator greatestCommonDivisorCalculator;

  public LeastCommonMultipleCalculatorImpl(final GreatestCommonDivisorCalculator greatestCommonDivisorCalculator) {
    this.greatestCommonDivisorCalculator = greatestCommonDivisorCalculator;
  }

  @Override
  public long calculateLeastCommonMultiple(final long a, final long b) {
    return ( a * b ) / this.greatestCommonDivisorCalculator.calculateGreatestCommonDivisor(a, b);
  }

  @Override
  public long calculateLeastCommonMultiple(final List<Long> values) {
    if (values.size() < 2) {
      throw new RuntimeException("No values");
    }

    return values.stream()
            .reduce(this::calculateLeastCommonMultiple)
            .get();
  }
}
