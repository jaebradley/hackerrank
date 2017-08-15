package algorithms.implementations;

import org.junit.Test;

import static org.junit.Assert.*;

public class PairDifferenceCounterTest {
    @Test
    public void itShouldReturnACountOfThree() {
        int[] values = new int[] { 1, 5, 3, 4, 2 };
        assertEquals(3, PairDifferenceCounter.countPairsWithDifference(values, 2));
    }
}