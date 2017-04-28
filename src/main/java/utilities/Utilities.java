package utilities;

import java.util.Stack;

public class Utilities {
  public static Stack<Character> toStackInReverseOrder(String s) {
    Stack<Character> characters = new Stack<Character>();
    char[] chars = s.toCharArray();
    for (int i = chars.length - 1; i > -1; i--) {
      characters.push(chars[i]);
    }
    return characters;
  }
}
