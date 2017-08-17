package algorithms.implementations;

import org.junit.Test;

import static org.junit.Assert.*;

public class BalancedArraySumValidatorTest {
    @Test
    public void itShouldFindBalancedArraySum() {
        int[] values = new int[] { 1, 1, 1, 3 };
        assertTrue(BalancedArraySumValidator.isArraySumBalanced(values));
    }

    @Test
    public void itShouldNotFindBalancedArraySum() {
        int[] values = new int[] { 1, 1, 1, 1 };
        assertFalse(BalancedArraySumValidator.isArraySumBalanced(values));
    }

    @Test
    public void itShouldReturnFalseForEmptyArray() {
        assertFalse(BalancedArraySumValidator.isArraySumBalanced(new int[] {}));
    }
}