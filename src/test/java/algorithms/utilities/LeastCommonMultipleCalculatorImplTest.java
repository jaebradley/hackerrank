package algorithms.utilities;

import algorithms.interfaces.GreatestCommonDivisorCalculator;
import algorithms.interfaces.LeastCommonMultipleCalculator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LeastCommonMultipleCalculatorImplTest {
  final long gcdConstant = 1;
  final GreatestCommonDivisorCalculator constantGcdCalculator = new GreatestCommonDivisorCalculator() {
    @Override
    public long calculateGreatestCommonDivisor(final long a, final long b) {
      return gcdConstant;
    }

    @Override
    public long calculateGreatestCommonDivisor(final Collection<Long> values) {
      return 0;
    }
  };

  final LeastCommonMultipleCalculator calculator = new LeastCommonMultipleCalculatorImpl(constantGcdCalculator);

  @Test
  public void itShouldCalculateLCM() {
    final long a = 3;
    final long b = 3;
    final long expected = ( a * b ) / gcdConstant;
    assertEquals(calculator.calculateLeastCommonMultiple(a, b), expected);
  }

  @Test
  public void itShouldThrowWhenValuesAreEmpty() {
    try {
      calculator.calculateLeastCommonMultiple(new ArrayList<>());
    } catch (RuntimeException e) {
      // expected
    }
  }

  @Test
  public void itShouldReturnLCMValues() {
    final long a = 3;
    final long b = 6;
    final long c = 9;
    final List<Long> values = new ArrayList<>();
    values.add(a);
    values.add(b);
    values.add(c);
    final long expected = a * b * c;
    assertEquals(calculator.calculateLeastCommonMultiple(values), expected);
  }
}