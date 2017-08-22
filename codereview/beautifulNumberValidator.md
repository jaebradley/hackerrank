## Problem
Adapted from [this HackerRank problem](https://www.hackerrank.com/challenges/separate-the-numbers/problem).

[![Beautiful Number Description][1]][1]

Instead of printing `YES` or `NO`, I just wanted to return a `boolean`.

## Implementation

<!-- language: lang-java -->

    public class BeautifulNumberValidator {
      public static boolean isValidBeautifulNumber(String s) {
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


  [1]: https://i.stack.imgur.com/p8HI7.png