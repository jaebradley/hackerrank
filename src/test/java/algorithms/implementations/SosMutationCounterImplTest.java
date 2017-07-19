package algorithms.implementations;

import algorithms.interfaces.SosMutationCounter;
import org.junit.Test;

import static org.junit.Assert.*;

public class SosMutationCounterImplTest {
  final SosMutationCounter counter = new SosMutationCounterImpl();

  @Test
  public void mutatedWhenFirstLetterIsNotS() {
    assertTrue(counter.wasMutated(1, 'A'));
  }

  @Test
  public void mutatedWhenFirstLetterIsNotO() {
    assertTrue(counter.wasMutated(2, 'A'));
  }

  @Test
  public void mutatedWhenThirdLetterIsNotS() {
    assertTrue(counter.wasMutated(3, 'A'));
  }

  @Test
  public void notMutatedWhenFirstLetterIsS() {
    assertFalse(counter.wasMutated(1, 'S'));
  }

  @Test
  public void notMutatedWhenFirstLetterIsO() {
    assertFalse(counter.wasMutated(2, 'O'));
  }

  @Test
  public void notMutatedWhenThirdLetterIsS() {
    assertFalse(counter.wasMutated(3, 'S'));
  }

  @Test
  public void throwsWhenLetterCountIsNotPositive() {
    try {
      counter.wasMutated(0, 'A');
    } catch (RuntimeException e) {
      // expected
    }
  }

  @Test
  public void itDoesNotCountWhenNoMutations() {
    assertEquals(counter.count("SOS"), 0);
  }

  @Test
  public void itDoesCountWhenMutations() {
    assertEquals(counter.count("ABC"), 3);
  }
}