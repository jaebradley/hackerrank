package algorithms.implementations;

import algorithms.interfaces.BeautifulNumberValidator;

/**
 * https://www.hackerrank.com/challenges/separate-the-numbers/problem
 * https://codereview.stackexchange.com/questions/169679/beautiful-number-validator/169705#169705
 *
 *  A numeric string, `s`, is beautiful if it can be split into a sequence of two or more positive integers, `a1`, `a2`, `a3`, etc., satisfying the following conditions
 *
 *    Each element in the sequence is one greater than the previous element
 *    No element contains a leading zero
 *    The sequence cannot be rearranged
 *
 *  For example, `1234` (`1`, `2`, `3`, `4`), `91011` (`9`, `10`, `11`), `99100` (`99`, `100`) are all beautiful numbers
 */

public class BeautifulNumberValidatorImpl implements BeautifulNumberValidator {
  public boolean isValidBeautifulNumber(String s, long prefix) {
    for (int i = 0; i < s.length(); ) {
      String number = String.valueOf(prefix);
      if (!s.substring(i, i + number.length()).equals(number)) {
        return false;
      }

      i += number.length();
      prefix++;
    }

    return true;
  }

  public boolean isValidBeautifulNumber(String s) {
    for (int substringSize = 1; substringSize <= s.length() / 2; substringSize++) {
      if (isValidBeautifulNumber(s, Long.parseLong(s.substring(0, substringSize)))) {
        return true;
      }
    }

    return false;
  }
}
