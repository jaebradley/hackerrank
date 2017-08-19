package algorithms.implementations;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-array?h_r=next-challenge&h_v=zen
 *
 * Watson gives Sherlock an array A of length n.
 * Then he asks him to determine if there exists an element in the array such that the sum of the elements on its left is equal to the sum of the elements on its right.
 * If there are no elements to the left/right, then the sum is considered to be zero.
 */

public class BalancedArraySumValidator {
    public static boolean isArraySumBalanced(int[] values) {
        return isArraySumBalancedFromLeftToRight(values) || isArraySumBalancedFromLeftToRight(reverse(values));
    }

    private static boolean isArraySumBalancedFromLeftToRight(int[] values) {
        if (values.length == 1) {
            return true;
        }

        int leftToRightLeftSum = 0;
        int leftToRightRightSum = 0;

        for (int i = 0; i < values.length; i++) {
            int j = values.length - 1 - i;

            if (i < j) {
                leftToRightRightSum += values[j];
            } else if (i > j) {
                leftToRightRightSum -= values[i];
            }

            if (leftToRightRightSum == leftToRightLeftSum) {
                return true;
            }

            leftToRightLeftSum += values[i];
        }

        return leftToRightRightSum == leftToRightLeftSum;
    }

    private static int[] reverse(int[] values) {
        int[] reversedArray = new int[values.length];

        for (int i = values.length - 1; i >= 0; i--) {
            reversedArray[values.length - 1 - i] = values[i];
        }

        return reversedArray;
    }
}
