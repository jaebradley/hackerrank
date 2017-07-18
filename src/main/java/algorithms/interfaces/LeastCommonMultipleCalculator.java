package algorithms.interfaces;

import java.util.List;

public interface LeastCommonMultipleCalculator {
  long calculateLeastCommonMultiple(final long a, final long b);
  long calculateLeastCommonMultiple(final List<Long> values);
}
