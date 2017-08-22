package algorithms.implementations;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-array?h_r=next-challenge&h_v=zen
 *
 * Given an array A of length n, determine if there exists an element in the array such that the sum of the elements on
 * its left is equal to the sum of the elements on its right.
 *
 * If there are no elements to the left/right, then the sum is considered to be zero.
 */

public class BalancedArraySumIdentifier {
    public static boolean isBalanced(int[] values) {
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
