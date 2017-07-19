package algorithms.implementations;

import algorithms.interfaces.AlphabeticalCharacterWeightCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlphabeticalCharacterWeightCalculatorImplTest {
  AlphabeticalCharacterWeightCalculator calculator = new AlphabeticalCharacterWeightCalculatorImpl();

  @Test
  public void itShouldThrowForNonAlphabeticCharacter() {
    try {
      calculator.calculate('1');
    } catch (RuntimeException e) {
      // expected
    }
  }

  @Test
  public void itShouldCalculateWeight() {
    assertEquals(calculator.calculate('A'), 1);
  }
}