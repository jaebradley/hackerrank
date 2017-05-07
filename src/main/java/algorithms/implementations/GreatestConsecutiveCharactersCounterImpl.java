package algorithms.implementations;

import algorithms.interfaces.GreatestConsecutiveCharactersCounter;

import java.util.HashMap;
import java.util.Map;

public class GreatestConsecutiveCharactersCounterImpl implements GreatestConsecutiveCharactersCounter {
  @Override
  public Map<Character, Long> getGreatestConsecutiveCharacterCounts(final String s) {
    if (s.isEmpty()) {
      return new HashMap<>();
    }

    Map<Character, Long> consecutiveCharacterCounts = new HashMap<>();
    char[] chars = s.toCharArray();

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
