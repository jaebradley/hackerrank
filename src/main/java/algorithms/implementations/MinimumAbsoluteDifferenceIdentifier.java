package algorithms.implementations;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array
 *
 * Given an array of N integers, find and print the minimum absolute difference between any two elements in the array.
 */

public class MinimumAbsoluteDifferenceIdentifier {
    public static int identifyMinimumAbsoluteDifference(int[] values) {
        if (values.length <= 1) {
            throw new IllegalArgumentException("Array must have at least two elements");
        }

        Arrays.sort(values);

        int minimumAbsoluteDifference = Math.abs(values[1] - values[0]);

        for (int i = 1, j = 2; j < values.length; i = j - 1, j++, i++) {
            int absoluteDifference = Math.abs(values[j] - values[i]);

            if (absoluteDifference < minimumAbsoluteDifference) {
                minimumAbsoluteDifference = absoluteDifference;
            }
        }

        return minimumAbsoluteDifference;
    }
}
