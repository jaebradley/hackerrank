## Problem

Adapted from [this HackerRank problem](https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem)

> Given a string `S`, find the unordered pairs of substrings that are anagrams of each other

> Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string.

## Approach

Another way of thinking about anagrams is that two strings are anagrams if the frequency of the characters in both strings is identical.
In other words, if you were to create a `Map` of the number of times every `Character` is found in each string, both `Map`s should be identical.

```
`abba` => `{ 'a': 2, 'b': 2 }`
`bbaa` => `{ 'a': 2, 'b': 2 }`
```

Thus, I approached the problem in the following way

1. Start with a pair count value of `0`
2. Iterate through all substrings of a given length
3. Create a `Map` that will keep track of all anagrams and their frequency (again, for substrings of the given length)
4. For each substring, represent the frequency of each `Character` using a `Map<Character, Integer>`
5. If the character frequencies calculated in Step #4 are not found in the key values of the `Map` created in Step #3 then
   add them to the `Map`.
   * If it does exist, then increment the pair count by the number of times the same anagram
   (i.e. character frequencies) have already been seen.
   * This is because for every time an identical anagram is seen, it can be
   paired with every previous instance of the same anagram.
   * After incrementing the pair count, also increment the number of times an anagram has been seen by `1`
6. Return the pair count value


## Implementation

<!-- language: lang-java -->

    public class UnorderedAnagrammaticPairsCounter {

      public static int countUnorderedAnagrammaticPairs(String s) {
        int count = 0;

        for (int substringLength = 1; substringLength <= s.length(); substringLength++) {
          Map<Map<Character, Integer>, Integer> substringsCounts = new HashMap<>();
          for (int index = 0; index <= s.length() - substringLength; index++) {
            String substring = s.substring(index, index + substringLength);
            Map<Character, Integer> characterCounts = UnorderedAnagrammaticPairsCounter.getCharacterCounts(substring);
            Integer substringCounts = substringsCounts.get(characterCounts);
            if (substringCounts == null) {
              substringsCounts.put(characterCounts, 1);
            } else {
              count += substringCounts;
              substringsCounts.put(characterCounts, substringCounts + 1);
            }
          }
        }

        return count;
      }

      public static Map<Character, Integer> getCharacterCounts(String s) {
        Map<Character, Integer> characterCounts = new HashMap<>();

        for (char c : s.toCharArray()) {
          Integer characterCount = characterCounts.get(c);
          if (characterCount == null) {
            characterCounts.put(c, 1);
          } else {
            characterCounts.put(c, characterCount + 1);
          }
        }

        return characterCounts;
      }
    }