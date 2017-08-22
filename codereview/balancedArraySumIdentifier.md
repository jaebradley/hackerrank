## Problem

Extended from [this HackerRank problem](https://www.hackerrank.com/challenges/sherlock-and-array).

> Given an array A of length n, determine if there exists an element in the array such that the sum of the elements on
its left is equal to the sum of the elements on its right.

If there are no elements to the left/right, then the sum is considered to be zero.

For example, `[ 1, 1, 1, 2 ]`, the sum of elements to the left and right of index `2`are equal.

## Approach

The following description is for the left-to-right evaluation of the array of values. In my implementation, I do both the
left-to-right and right-to-left evaluations in the same loop.

1. Given an array of values, start with the first and last index. These will be the initial values of the left and
   right sums and the initial left and right indices
2. Increment the left index by `1` and decrement the right index by `1`
   1. If the left index is less than the right index, add the value at the right index to the right sum
   2. If the left index is greater than the right index, subtract the value at the left index from the right sum
   3. If the left and right sums are the same, then `return` early
   4. Else, add the value at the left index to the left sum
3. After exiting the loop, check if the left sum is equal to the right sum

## Implementation

    public class BalancedArraySumIdentifier {
        public static boolean isArraySumBalanced(int[] values) {
            int leftToRightLeftSum = 0;
            int leftToRightRightSum = 0;

            int rightToLeftRightSum = 0;
            int rightToLeftLeftSum = 0;

            for (int i = 0; i < values.length; i++) {
                int j = values.length - 1 - i;

                if (i < j) {
                    leftToRightRightSum += values[j];
                    rightToLeftLeftSum += values[i];
                } else if (i > j) {
                    leftToRightRightSum -= values[i];
                    rightToLeftLeftSum -= values[j];
                }

                if (leftToRightLeftSum == leftToRightRightSum || rightToLeftLeftSum == rightToLeftRightSum) {
                    return true;
                }

                leftToRightLeftSum += values[i];
                rightToLeftRightSum += values[j];
            }

            return leftToRightLeftSum == leftToRightRightSum || rightToLeftLeftSum == rightToLeftRightSum;
        }
    }
