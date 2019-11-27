package com.marlo.games;

import static java.nio.file.Files.lines;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

/** Java solution to the 9 letter word puzzle. */
@Command(
    name = "WordPuzzleApp",
    mixinStandardHelpOptions = true,
    version = "WordPuzzleApp 1.0.1",
    description = "Solve 9 letter word puzzle.")
@Slf4j
public final class WordPuzzleApp implements Runnable {

  /** Minimum word size. */
  @Option(
      names = {"-s", "--size"},
      description = "minimum word size",
      defaultValue = "4")
  @Getter
  private int size;

  /** Mandatory character. Every word must contain this character. */
  @Option(
      names = {"-m", "--mandatory"},
      description = "mandatory character")
  @Getter
  private String mandatory;

  /** Words must contain only these letters. */
  @Option(
      names = {"-l", "--letters"},
      description = "letters to create words from")
  @Getter
  private String letters;

  /** The file to search. */
  @Option(
      names = {"-d", "--dictionary"},
      description = "dictionary to use in word search",
      defaultValue = "dictionary/british")
  @Getter
  private File dictionary;

  /** Get valid words from dictionary. */
  public void findWords() {
    final Path path = Paths.get(dictionary.getAbsolutePath());
    try {
      lines(path)
          .filter(word -> size <= word.length()) // not too small
          .filter(word -> word.length() <= 9) // not too large
          .filter(word -> word.contains(mandatory)) // contains mandatory character
          .filter(word -> WordPuzzleUtils.isValid(letters, word)) // contains only valid characters
          .forEach(System.out::println);
    } catch (IOException e) {
      log.error("Could not read file {}", dictionary.toString());
    }
  }

  /** Validate arguments then search dictionary for valid words. */
  @Override
  public void run() {
    final WordPuzzleBean bean = new WordPuzzleBean(size, mandatory, letters);
    if (bean.validate()) {
      findWords();
    } else {
      bean.getValidations().stream().forEach(e -> log.error("Validation: {}", e.getMessage()));
    }
  }

  /**
   * Search file for string using Streams. Get file name from first argument.
   *
   * @param args the input arguments
   */
  public static void main(final String[] args) {
    new CommandLine(new WordPuzzleApp()).execute(args);
  }
}
