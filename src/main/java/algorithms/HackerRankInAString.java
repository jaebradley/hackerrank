package algorithms;


import utilities.Utilities;

import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/hackerrank-in-a-string
 * We say that a string, S, contains the word hackerrank if a subsequence of the characters in S spell the word hackerrank.
 * For example, haacckkerrannkk does contain hackerrank, but haacckkerannk does not
 * (the characters all appear in the same order, but it's missing a second r).
 */

public class HackerRankInAString {
  public static final String HACKER_RANK = "hackerrank";
  
  public static boolean containsHackerRankSubSequence(String s) {
    Stack<Character> hackerRankCharacters = Utilities.toStackInReverseOrder(HACKER_RANK);
    for (char c : s.toLowerCase().toCharArray()) {
      if (!hackerRankCharacters.empty() && hackerRankCharacters.peek() == c) {
        hackerRankCharacters.pop();
      }
    }

    return hackerRankCharacters.empty();
  }
}
