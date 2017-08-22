package algorithms.implementations;

import org.junit.Test;

import static org.junit.Assert.*;

public class BalancedArraySumIdentifierTest {
    @Test
    public void itShouldFindBalancedArraySum() {
        assertFalse(BalancedArraySumIdentifier.isArraySumBalanced(new int[] { 1, 1, 1, 3 }));
    }

    @Test
    public void itShouldNotFindBalancedArraySum() {
        assertFalse(BalancedArraySumIdentifier.isArraySumBalanced(new int[] { 1, 1, 1, 1 }));
    }

    @Test
    public void itShouldReturnFalseForEmptyArray() {
        assertTrue(BalancedArraySumIdentifier.isArraySumBalanced(new int[] {}));
    }

    @Test
    public void itShouldReturnTrueForSingleArray() {
        assertTrue(BalancedArraySumIdentifier.isArraySumBalanced(new int[] { 3 }));
    }

    @Test
    public void itShouldReturnTrue() {
        assertTrue(BalancedArraySumIdentifier.isArraySumBalanced(new int[] { 1, 2, 3, 3 }));
    }

    @Test
    public void itShouldReturnTrueForMiddle() {
        assertTrue(BalancedArraySumIdentifier.isArraySumBalanced(new int[] { 3, 2, 3 }));
    }

    @Test
    public void itShouldReturnFalse() {
        assertFalse(BalancedArraySumIdentifier.isArraySumBalanced(new int[] { 1, 2, 3 }));
    }

    @Test
    public void itShouldReturnTrueForNegatives() {
        assertTrue(BalancedArraySumIdentifier.isArraySumBalanced(new int[] { 1, 1, -1, -1 }));
    }
}