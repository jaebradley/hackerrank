package algorithms.implementations;

import algorithms.interfaces.AlphabeticalCharacterWeightCalculator;

/**
 * As defined in https://www.hackerrank.com/challenges/weighted-uniform-string, the weight of a lowercase English letter is its
 * 1-indexed distance from 'a', alphabetically.
 *
 * For example:
 * a = 1
 * b = 2
 * c = 3
 * ...
 * x = 24
 * y = 25
 * z = 26
 */

public class AlphabeticalCharacterWeightCalculatorImpl implements AlphabeticalCharacterWeightCalculator {
  @Override
  public long calculate(final char c) {
    if (!Character.isAlphabetic(c)) {
      throw new RuntimeException("Must be an alphabetical character");
    }

    return Character.toLowerCase(c) - 'a' + 1;
  }
}
