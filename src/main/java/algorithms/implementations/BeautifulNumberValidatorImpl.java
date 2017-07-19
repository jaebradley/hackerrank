package algorithms.implementations;

import algorithms.interfaces.BeautifulNumberValidator;

/**
 * https://www.hackerrank.com/challenges/separate-the-numbers/problem
 */

public class BeautifulNumberValidatorImpl implements BeautifulNumberValidator {
  @Override
  public boolean isValidBeautifulNumber(final String s) {
    if (s.length() < 2) {
      return false;
    }

    for (int substringSize = 1; substringSize <= s.length() / 2; substringSize++) {
      long value = Long.parseLong(s.substring(0, substringSize));

      if (value == 0) {
        break;
      }

      StringBuilder sb = new StringBuilder();
      sb.append(value);

      while (sb.length() < s.length() && sb.toString().equals(s.substring(0, sb.length()))) {
        sb.append(++value);
      }

      if (sb.toString().equals(s)) {
        return true;
      }
    }

    return false;
  }
}
