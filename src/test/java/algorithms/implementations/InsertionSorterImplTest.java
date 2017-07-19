package algorithms.implementations;

import algorithms.interfaces.InsertionSorter;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class InsertionSorterImplTest {
  final InsertionSorter sort = new InsertionSorterImpl();

  @Test
  public void itShouldSortTrivialCase() {
    final int[] test = new int[] {1};
    final int[] expected = new int[] {1};
    assertArrayEquals(sort.sortAscending(test), expected);
  }

  @Test
  public void itShouldReturnIdenticalArray() {
    final int[] test = new int[] {1, 2, 3, 4, 5};
    final int[] expected = new int[] {1, 2, 3, 4, 5};
    assertArrayEquals(sort.sortAscending(test), expected);
  }

  @Test
  public void itShouldReturnReverseArray() {
    final int[] test = new int[] {5, 4, 3, 2, 1};
    final int[] expected = new int[] {1, 2, 3, 4, 5};
    assertArrayEquals(sort.sortAscending(test), expected);
  }
}