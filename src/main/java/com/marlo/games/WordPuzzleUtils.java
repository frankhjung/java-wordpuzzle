package com.marlo.games;

import java.util.List;
import java.util.stream.Collectors;

/** Word puzzle utilities. */
public final class WordPuzzleUtils {
  /**
   * Check if a dictionary word is valid.
   *
   * @param letters the letters to validate against
   * @param word the dictionary word to check
   * @return true if word is valid
   */
  public static boolean isValid(final String letters, final String word) {
    final List<Character> lettersList =
        letters.chars().mapToObj(letter -> (char) letter).collect(Collectors.toList());
    for (final Character w : word.toCharArray()) {
      final boolean changed = lettersList.remove(w);
      if (!changed) {
        return false;
      }
    }
    return true;
  }
}
