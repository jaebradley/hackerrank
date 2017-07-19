package algorithms.implementations;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnorderedAnagrammaticPairsCounterImplTest {
  final UnorderedAnagrammaticPairsCounterImpl counter = new UnorderedAnagrammaticPairsCounterImpl();

  @Test
  public void itShouldReturnPairs() {
    assertEquals(4, counter.countUnorderedAnagrammaticPairs("abba"));
  }

  @Test
  public void itShouldReturnSixPairs() {
    assertEquals(6, counter.countUnorderedAnagrammaticPairs("pvmupwjjjf"));
  }
}