package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HackerRankInAStringTest {

  @Test
  public void testNoMatches() {
    assertFalse(HackerRankInAString.containsHackerRankSubSequence(""));
  }

  @Test
  public void testMatch() {
    assertTrue(HackerRankInAString.containsHackerRankSubSequence(HackerRankInAString.HACKER_RANK));
  }

  @Test
  public void testEmptyEarlyExist() {
    assertTrue(HackerRankInAString.containsHackerRankSubSequence(HackerRankInAString.HACKER_RANK + HackerRankInAString.HACKER_RANK));
  }
}