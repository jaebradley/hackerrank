package algorithms.utilities;

import algorithms.interfaces.GreatestCommonDivisorCalculator;

public class GreatestCommonDivisorCalculatorImpl implements GreatestCommonDivisorCalculator {
  @Override
  public long calculateGreatestCommonDivisor(final long a, final long b) {
    if (a == 0 && b != 0) {
      return b;
    }

    if (b == 0 && a != 0) {
      return a;
    }

    long first = a;
    long second = b;

    while (first != second) {
      if (first > second) {
        first = first - second;
      } else {
        second = second - first;
      }
    }

    return first;
  }
}
