package algorithms.interfaces;

import java.util.Collection;

public interface GreatestCommonDivisorCalculator {
  long calculateGreatestCommonDivisor(final long a, final long b);
  long calculateGreatestCommonDivisor(final Collection<Long> values);
}
