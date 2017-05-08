package algorithms.implementations;

import algorithms.interfaces.AlphabeticalCharacterWeightCalculator;
import algorithms.interfaces.GreatestConsecutiveCharactersCounter;
import algorithms.interfaces.UniformSubStringWeightsFetcher;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UniformSubStringWeightsFetcherImplTest {
  final AlphabeticalCharacterWeightCalculator unimplementedCharacterWeightCalculator = new AlphabeticalCharacterWeightCalculator() {
    @Override
    public long calculate(final char c) {
      return 0L;
    }
  };

  final AlphabeticalCharacterWeightCalculator simpleCharacterWeightCalculator = new AlphabeticalCharacterWeightCalculator() {
    @Override
    public long calculate(final char c) {
      return 1L;
    }
  };

  final GreatestConsecutiveCharactersCounter returnsEmptyCharacterCounts = new GreatestConsecutiveCharactersCounter() {
    @Override
    public Map<Character, Long> getGreatestConsecutiveCharacterCounts(final String s) {
      return new HashMap<>();
    }
  };

  final GreatestConsecutiveCharactersCounter returnsMapWithNullKeys = new GreatestConsecutiveCharactersCounter() {
    @Override
    public Map<Character, Long> getGreatestConsecutiveCharacterCounts(final String s) {
      final Map<Character, Long> characterCounts = new HashMap<>();
      characterCounts.put(null, 1L);
      return characterCounts;
    }
  };

  final GreatestConsecutiveCharactersCounter returnsMapWithNullValues = new GreatestConsecutiveCharactersCounter() {
    @Override
    public Map<Character, Long> getGreatestConsecutiveCharacterCounts(final String s) {
      final Map<Character, Long> characterCounts = new HashMap<>();
      characterCounts.put(null, 1L);
      return characterCounts;
    }
  };

  final GreatestConsecutiveCharactersCounter returnsMap = new GreatestConsecutiveCharactersCounter() {
    @Override
    public Map<Character, Long> getGreatestConsecutiveCharacterCounts(final String s) {
      final Map<Character, Long> characterCounts = new HashMap<>();
      characterCounts.put('a', 1L);
      characterCounts.put('b', 2L);
      characterCounts.put('c', 3L);
      return characterCounts;
    }
  };

  @Test
  public void itShouldReturnEmptySetWhenNoConsecutiveCharacters() {
    final UniformSubStringWeightsFetcher weightsFetcher = new UniformSubStringWeightsFetcherImpl(unimplementedCharacterWeightCalculator, returnsEmptyCharacterCounts);
    assertTrue(weightsFetcher.getWeights("jaebaebae").isEmpty());
  }

  @Test
  public void itShouldReturnEmptySetWhenNullKeys() {
    final UniformSubStringWeightsFetcher weightsFetcher = new UniformSubStringWeightsFetcherImpl(unimplementedCharacterWeightCalculator, returnsMapWithNullKeys);
    assertTrue(weightsFetcher.getWeights("jaebaebae").isEmpty());
  }

  @Test
  public void itShouldReturnEmptySetWhenNullValues() {
    final UniformSubStringWeightsFetcher weightsFetcher = new UniformSubStringWeightsFetcherImpl(unimplementedCharacterWeightCalculator, returnsMapWithNullValues);
    assertTrue(weightsFetcher.getWeights("jaebaebae").isEmpty());
  }

  @Test
  public void itShouldCalculateWeights() {
    final UniformSubStringWeightsFetcher weightsFetcher = new UniformSubStringWeightsFetcherImpl(simpleCharacterWeightCalculator, returnsMap);
    final Set<Long> weights = weightsFetcher.getWeights("jaebaebae");
    assertEquals(weights.size(), 3);
    assertTrue(weights.contains(1L));
    assertTrue(weights.contains(2L));
    assertTrue(weights.contains(3L));
  }
}