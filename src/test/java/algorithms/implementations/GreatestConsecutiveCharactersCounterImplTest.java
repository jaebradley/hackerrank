package algorithms.implementations;

import algorithms.interfaces.GreatestConsecutiveCharactersCounter;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class GreatestConsecutiveCharactersCounterImplTest {
  final GreatestConsecutiveCharactersCounter counter = new GreatestConsecutiveCharactersCounterImpl();

  @Test
  public void itShouldReturnEmptyMapForEmptyString() {
    assertEquals(counter.getGreatestConsecutiveCharacterCounts(""), new HashMap<>());
  }

  @Test
  public void itShouldReturnMapWithSingleValue() {
    final Map<Character, Long> expected = new HashMap<>();
    expected.put('a', 1L);
    assertEquals(counter.getGreatestConsecutiveCharacterCounts("a") ,expected );
  }

  @Test
  public void itShouldReturnMapWithTwoValues() {
    final Map<Character, Long> expected = new HashMap<>();
    expected.put('a', 1L);
    expected.put('b', 1L);
    assertEquals(counter.getGreatestConsecutiveCharacterCounts("ab") ,expected );
  }

  @Test
  public void itShouldReturnMapWithOneValueWithManyCounts() {
    final Map<Character, Long> expected = new HashMap<>();
    expected.put('a', 3L);
    assertEquals(counter.getGreatestConsecutiveCharacterCounts("aaa") ,expected );
  }
}