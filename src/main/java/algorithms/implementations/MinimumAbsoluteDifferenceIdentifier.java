package algorithms.implementations;

import java.util.Arrays;

public class MinimumAbsoluteDifferenceIdentifier {
    public static int identifyMinimumAbsoluteDifference(int[] values) {
        if (values.length <= 1) {
            throw new IllegalArgumentException("Array must have at least two elements");
        }

        Arrays.sort(values);

        int minimumAbsoluteDifference = Integer.MAX_VALUE;

        for (int i = 0, j = 1; j < values.length; i = j - 1, j++, i++) {
            int absoluteDifference = Math.abs(values[j] - values[i]);

            if (absoluteDifference < minimumAbsoluteDifference) {
                minimumAbsoluteDifference = absoluteDifference;
            }
        }

        return minimumAbsoluteDifference;
    }
}
