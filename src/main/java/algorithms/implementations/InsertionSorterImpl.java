package algorithms.implementations;

import algorithms.interfaces.InsertionSorter;

/**
 * https://en.wikipedia.org/wiki/Insertion_sort
 * https://www.hackerrank.com/challenges/insertionsort2?h_r=next-challenge&h_v=zen
 */

public class InsertionSorterImpl implements InsertionSorter {
  @Override
  public int[] sortAscending(final int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      final int currentValue = arr[i];
      for (int j = i - 1; j >= 0 && currentValue < arr[j]; j--) {
        final int comparisonValue = arr[j];
        arr[j] = currentValue;
        arr[j + 1] = comparisonValue;
      }
    }

    return arr;
  }
}
