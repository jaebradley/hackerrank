package algorithms.interfaces;

public interface SosMutationCounter {
  int count(final String s);
  boolean wasMutated(int index, char letter);
}
