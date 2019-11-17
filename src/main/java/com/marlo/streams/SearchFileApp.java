package com.marlo.streams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

/** Example on how to read file as a stream. */
@Slf4j
@Command(
    name = "SearchFile",
    mixinStandardHelpOptions = true,
    version = "SearchFile 1.0.0",
    description = "Search file for string")
public final class SearchFileApp implements Runnable {

  /** The string to search for. */
  @Option(
      names = {"-s", "--search"},
      description = "string to search for")
  @Getter
  private String search = "";

  /** The file to search. */
  @Parameters(index = "0", description = "file to search")
  @Getter
  private File file = null;

  /** Search file using a stream. */
  public void run() {
    final Path path = Paths.get(file.getAbsolutePath());
    try {
      Files.lines(path)
          .filter(line -> line.toLowerCase(Locale.ENGLISH).contains(search))
          .forEach(System.out::println);
    } catch (IOException e) {
      log.error("Could not read file {}", path.toString());
    }
  }

  /**
   * Search file for string using Streams. Get file name from first argument.
   *
   * @param args the input arguments
   */
  public static void main(final String[] args) {
    new CommandLine(new SearchFileApp()).execute(args);
  }
}
