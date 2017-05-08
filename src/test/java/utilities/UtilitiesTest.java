package utilities;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class UtilitiesTest {

  @Test
  public void testEmptyString() {
    assertEquals(Utilities.toStackInReverseOrder(""), new Stack<Character>());
  }

  @Test
  public void testNonEmptyString() {
    Stack<Character> expected = new Stack<Character>();
    expected.push('e');
    expected.push('a');
    expected.push('j');
    assertEquals(Utilities.toStackInReverseOrder("jae"), expected);
  }

}