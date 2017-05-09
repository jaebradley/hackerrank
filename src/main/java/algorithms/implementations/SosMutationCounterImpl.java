package algorithms.implementations;

import algorithms.interfaces.SosMutationCounter;

/**
 * https://www.hackerrank.com/challenges/mars-exploration
 */

public class SosMutationCounterImpl implements SosMutationCounter {
  @Override
  public int count(final String s) {
    int mutationCount = 0;
    final char[] chars = s.toCharArray();
    for (int i = 1; i <= chars.length; i++) {
      if (this.wasMutated(i, chars[i - 1])) {
        mutationCount++;
      }
    }
    return mutationCount;
  }

  @Override
  public boolean wasMutated(final int letterOrder, final char letter) {
    if (letterOrder < 1) {
      throw new RuntimeException("Letter order must be a positive number");
    }

    final int modulo = letterOrder % 3;
    return ((modulo == 1 || modulo == 0) && letter != 'S') ||  (modulo == 2 && letter != 'O');
  }
}
