## Problem
Adapted from [this HackerRank problem](https://www.hackerrank.com/challenges/weighted-uniform-string).

[![Weighted Uniform String Problem][1]][1]


Instead of printing `YES` or `NO`, I just want to return the `Set` of all possible weights for an input `String`.

I found this example to be illustrative

[![Example Weighted Uniform Strings][2]][2]

# Implementation

Some of my thoughts are in the implementation as comments

<!-- language: lang-java -->

    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.Map;
    import java.util.Set;

    public class WeightedUniformStrings {
      public static Set<Long> getWeights(String s) {
        // I thought about using streams here, but I'm not using java 8
        Set<Long> weights = new HashSet<>();
        Map<Character, Long> consecutiveCharacterCounts = WeightedUniformStrings.getConsecutiveCharactersCounts(s);
        for (Map.Entry<Character, Long> entry : consecutiveCharacterCounts.entrySet()) {
          if (entry.getValue() != null && entry.getKey() != null) {
            long weight = WeightedUniformStrings.calculateWeight(entry.getKey());
            for (long i = 0; i < entry.getValue() + 1; i++) {
              weights.add(weight * i);
            }
          }
        }
        return weights;
      }

      private static long calculateWeight(char c) {
        // Could add a check to see if character is alphabetical
        return Character.toLowerCase(c) - 'a' + 1;
      }

      private static Map<Character, Long> getConsecutiveCharactersCounts(String s) {
        if (s.isEmpty()) {
          return new HashMap<>();
        }

        Map<Character, Long> consecutiveCharacterCounts = new HashMap<>();
        char[] chars = s.toCharArray();

        // I'm not a big fan of this initialization + for loop - but I haven't thought of a better alternative implementation
        char startingCharacter = chars[0];
        long consecutiveCharacterCount = 1;
        consecutiveCharacterCounts.put(startingCharacter, consecutiveCharacterCount);

        for (int i = 1; i < chars.length; i++) {
          char currentCharacter = chars[i];

          if (currentCharacter == startingCharacter) {
            consecutiveCharacterCount++;
          }

          if (currentCharacter != startingCharacter || i == chars.length - 1) {
            Long characterCount = consecutiveCharacterCounts.get(startingCharacter);
            if (characterCount == null || consecutiveCharacterCount > characterCount) {
              consecutiveCharacterCounts.put(startingCharacter, consecutiveCharacterCount);
            }
          }

          // Doing this logical check twice feels weird
          if (currentCharacter != startingCharacter) {
            startingCharacter = currentCharacter;
            consecutiveCharacterCount = 1;
            Long characterCount = consecutiveCharacterCounts.get(startingCharacter);
            if (characterCount == null || consecutiveCharacterCount > characterCount) {
              consecutiveCharacterCounts.put(startingCharacter, consecutiveCharacterCount);
            }
          }
        }

        return consecutiveCharacterCounts;
      }
    }


  [1]: https://i.stack.imgur.com/s7m5W.png
  [2]: https://i.stack.imgur.com/nYOjY.png