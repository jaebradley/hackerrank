package algorithms.interfaces;

import java.util.Collection;

public interface LeastCommonMultipleCalculator {
  long calculateLeastCommonMultiple(final long a, final long b);
  long calculateLeastCommonMultiple(final Collection<Long> values);
}
