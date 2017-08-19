package algorithms.implementations;

import org.junit.Test;

import static org.junit.Assert.*;

public class BalancedArraySumValidatorTest {
    @Test
    public void itShouldFindBalancedArraySum() {
        assertFalse(BalancedArraySumValidator.isArraySumBalanced(new int[] { 1, 1, 1, 3 }));
    }

    @Test
    public void itShouldNotFindBalancedArraySum() {
        assertFalse(BalancedArraySumValidator.isArraySumBalanced(new int[] { 1, 1, 1, 1 }));
    }

    @Test
    public void itShouldReturnFalseForEmptyArray() {
        assertTrue(BalancedArraySumValidator.isArraySumBalanced(new int[] {}));
    }

    @Test
    public void itShouldReturnTrueForSingleArray() {
        assertTrue(BalancedArraySumValidator.isArraySumBalanced(new int[] { 3 }));
    }

    @Test
    public void itShouldReturnTrue() {
        assertTrue(BalancedArraySumValidator.isArraySumBalanced(new int[] { 1, 2, 3, 3 }));
    }

    @Test
    public void itShouldReturnTrueForMiddle() {
        assertTrue(BalancedArraySumValidator.isArraySumBalanced(new int[] { 3, 2, 3 }));
    }

    @Test
    public void itShouldReturnFalse() {
        assertFalse(BalancedArraySumValidator.isArraySumBalanced(new int[] { 1, 2, 3 }));
    }

    @Test
    public void itShouldReturnTrueForNegatives() {
        assertTrue(BalancedArraySumValidator.isArraySumBalanced(new int[] { 1, 1, -1, -1 }));
    }
}