package algorithms.implementations;

import algorithms.interfaces.AlphabeticalCharacterWeightCalculator;
import algorithms.interfaces.GreatestConsecutiveCharactersCounter;
import algorithms.interfaces.UniformSubStringWeightsFetcher;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniformSubStringWeightsFetcherImpl implements UniformSubStringWeightsFetcher {
  private final AlphabeticalCharacterWeightCalculator alphabeticalCharacterWeightCalculator;
  private final GreatestConsecutiveCharactersCounter greatestConsecutiveCharactersCounter;

  public UniformSubStringWeightsFetcherImpl(final AlphabeticalCharacterWeightCalculator alphabeticalCharacterWeightCalculator,
                                            final GreatestConsecutiveCharactersCounter greatestConsecutiveCharactersCounter) {
    this.alphabeticalCharacterWeightCalculator = alphabeticalCharacterWeightCalculator;
    this.greatestConsecutiveCharactersCounter = greatestConsecutiveCharactersCounter;
  }

  @Override
  public Set<Long> getWeights(final String s) {
    Set<Long> weights = new HashSet<>();
    Map<Character, Long> consecutiveCharacterCounts = this.greatestConsecutiveCharactersCounter.getGreatestConsecutiveCharacterCounts(s);
    for (Map.Entry<Character, Long> entry : consecutiveCharacterCounts.entrySet()) {
      if (entry.getValue() != null && entry.getKey() != null) {
        long weight = this.alphabeticalCharacterWeightCalculator.calculate(entry.getKey());
        for (long i = 1; i < entry.getValue() + 1; i++) {
          weights.add(weight * i);
        }
      }
    }
    return weights;
  }
}
