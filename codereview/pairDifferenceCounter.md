## Problem

Adapted from [this HackerRank Problem](https://www.hackerrank.com/challenges/pairs/problem).

> Given `N` integers, count the number of pairs of integers whose difference is `K`.

## Approach

1. Given the initial `int` array, sort it.
2. Now iterate through the indices in the array using a lower index (starting at `0`) and an upper index (starting at `1`)`.
3. Calculate the difference between the value at the upper index value and the value at the lower index
  a. If the difference is equal to the target difference, increment the count and increment the upper index.
  b. If the difference is less than the target difference, increment the upper index. A difference less than the target
     difference implies that the value at the upper index is not large enough.
  c. If the difference is greater than the target difference, increment the lower index. A difference greater than the
     target implies that the value at the lower index is not large enough.
4. Return the count

## Implementation

<!--language: lang-java -->

    public class PairDifferenceCounter {
        public static int countPairsWithDifference(int[] values, int difference) {
            Arrays.sort(values);

            int count = 0;
            int lowerIndex = 0;
            int upperIndex = 1;

            while (upperIndex < values.length) {
                int pairDifference = values[upperIndex] - values[lowerIndex];

                if (pairDifference == difference) {
                    count++;
                    upperIndex++;
                } else if (pairDifference > difference) {
                    lowerIndex++;
                } else {
                    upperIndex++;
                }
            }

            return count;
        }
    }