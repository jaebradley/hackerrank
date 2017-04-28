package algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

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