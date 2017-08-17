package algorithms.implementations;

public class BalancedArraySumValidator {
    public static boolean isArraySumBalanced(int[] values) {
        return isArraySumBalancedFromLeftToRight(values) || isArraySumBalancedFromLeftToRight(reverse(values));
    }

    private static boolean isArraySumBalancedFromLeftToRight(int[] values) {
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < values.length; i++) {
            leftSum += values[i];

            if (i < values.length / 2) {
                rightSum += values[values.length - 1 - i];
            } else {
                rightSum -= values[i];
            }

            if (rightSum == leftSum) {
                return true;
            }
        }

        return false;
    }

    private static int[] reverse(int[] values) {
        int[] reversedArray = new int[values.length];

        int index = 0;
        for (int i = values.length - 1; i >= 0; i--) {
            reversedArray[index] = values[i];
            index++;
        }

        return reversedArray;
    }
}
