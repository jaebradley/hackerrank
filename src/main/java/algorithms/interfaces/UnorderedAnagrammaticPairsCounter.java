package algorithms.interfaces;

import java.util.Map;

public interface UnorderedAnagrammaticPairsCounter {
  int countUnorderedAnagrammaticPairs(String s);
  Map<Character, Integer> getCharacterCounts(String s);
}
