package algorithms.implementations;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumAbsoluteDifferenceIdentifierTest {
    @Test
    public void testMinimumAbsoluteDifference() {
        final int[] values = new int[] { 3, -7, 0 };
        assertEquals(3, MinimumAbsoluteDifferenceIdentifier.identifyMinimumAbsoluteDifference(values));
    }

    @Test
    public void itThrowsForEmptyValues() {
        try {
            MinimumAbsoluteDifferenceIdentifier.identifyMinimumAbsoluteDifference(new int[] {});
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}