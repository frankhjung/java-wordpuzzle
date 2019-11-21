package com.marlo.games;

import static java.nio.file.Files.lines;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.Getter;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

/** Java solution to the 9 letter word puzzle. */
@Command(
    name = "WordPuzzleApp",
    mixinStandardHelpOptions = true,
    version = "WordPuzzleApp 1.0.0",
    description = "Solve 9 letter word puzzle.")
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
  private Character mandatory;

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

  /** Search file using a stream. */
  @Override
  public void run() {
    final Path path = Paths.get(dictionary.getAbsolutePath());
    try {
      lines(path)
          .filter(word -> size <= word.length()) // not too small
          .filter(word -> word.length() <= 9) // not too large
          .filter(word -> word.contains(mandatory.toString())) // contains mandatory character
          .filter(word -> WordPuzzleUtils.isValid(letters, word)) // contains only valid characters
          .forEach(System.out::println);
    } catch (IOException e) {
      System.err.printf("Could not read file %s", dictionary.toString());
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
