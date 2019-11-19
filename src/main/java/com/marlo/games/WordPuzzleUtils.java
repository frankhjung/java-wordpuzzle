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
    List<Character> lettersList =
        letters.chars().mapToObj(letter -> (char) letter).collect(Collectors.toList());
    List<Character> wordAsList =
        word.chars().mapToObj(letter -> (char) letter).collect(Collectors.toList());
    for (Character letter : lettersList) {
      wordAsList.remove(letter);
    }
    return wordAsList.isEmpty();
  }
}
