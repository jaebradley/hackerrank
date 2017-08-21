## Problem

From [this Hackerrank problem](https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array).

> Given an array of N integers, find and print the minimum absolute difference between any two elements in the array.

## Approach

1. If there are less than two values in the array, throw an `IllegalArgumentException`. It's hard to find a difference
   between `0` or `1` integers.
2. Sort the input array.
3. Set the initial minimum absolute difference to the absolute value of the difference between the value in index `1`
   and the value in index `0`.
4. Iterate through the sorted array and see if the absolute difference between two indices are less than the current
   absolute difference. If so, this absolute difference becomes the new minimum value.
5. Return the minimum value.

## Implementation

<!-- language: lang-java -->
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