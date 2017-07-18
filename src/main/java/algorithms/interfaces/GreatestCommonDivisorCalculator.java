package algorithms.interfaces;

import java.util.List;

public interface GreatestCommonDivisorCalculator {
  long calculateGreatestCommonDivisor(final long a, final long b);
  long calculateGreatestCommonDivisor(final List<Long> values);
}
