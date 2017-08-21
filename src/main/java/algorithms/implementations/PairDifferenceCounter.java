package algorithms.implementations;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/pairs/problem
 *
 * Given N integers, count the number of pairs of integers whose difference is K.
 */

public class PairDifferenceCounter {
    public static int countPairsWithDifference(int[] values, int difference) {
        Arrays.sort(values);

        int count = 0;
        int lowerIndex = 0;
        int upperIndex = 1;

        while (upperIndex < values.length && lowerIndex < upperIndex) {
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
