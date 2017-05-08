package algorithms.interfaces;

import java.util.Set;

public interface UniformSubStringWeightsFetcher {
  Set<Long> getWeights(final String s);
}
