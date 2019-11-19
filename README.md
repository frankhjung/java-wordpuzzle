# Java Solution to 9 Letter Word Puzzle

Play with Java Streams and solve [9 Letter word Puzzle]().

See also the Haskell solution.

## Build

To build this project with Maven, run

```bash
mvn clean validate fmt:format sortpom:sort package
```

This will format code, sort POM and create a JAR package.

## Documentation

To generate documentation run:

```bash
mvn javadoc:javadoc site
```

## Run

From [über executable JAR](https://maven.apache.org/plugins/maven-shade-plugin/examples/executable-jar.html):

```bash
mvn exec:java -Dexec.mainClass=com.marlo.games.WordPuzzleApp -Dexec.args="-s <size> -m <mandatory> -l <letters> [-d <dictionary>]"
java -cp target/com.marlo.games-wordpuzzle.jar com.marlo.games.WordPuzzleApp -s <size> -m <mandatory> -l <letters> [-d <dictionary>]
```

## Examples

### Help

Print program help message:

```bash
java -cp target/com.marlo.games.jar com.marlo.games.WordPuzzleApp -h
```

Help message:

```text
$ java -cp target/com.marlo.games-wordpuzzle.jar com.marlo.games.WordPuzzleApp -h
Usage: WordPuzzleApp [-hV] [-d=<dictionary>] [-l=<letters>] [-m=<mandatory>]
                     [-s=<size>]
Solve 9 letter word puzzle.
  -d, --dictionary=<dictionary>
                            dictionary to use in word search
  -h, --help                Show this help message and exit.
  -l, --letters=<letters>   letters to create words from
  -m, --mandatory=<mandatory>
                            mandatory character
  -s, --size=<size>         minimum word size
  -V, --version             Print version information and exit.
```

Version:

```text
$ java -cp target/com.marlo.games-wordpuzzle.jar com.marlo.games.WordPuzzleApp -V
WordPuzzleApp 1.0.0
```

### Run

Run puzzle solution over reference data:

```bash
mvn exec:java -Dexec.mainClass=com.marlo.games.WordPuzzleApp -Dexec.args="-s 4 -m c -l adevcrsoi"
java -cp target/com.marlo.games.jar com.marlo.games.WordPuzzleApp -s 4 -m c -l adevcrsoi
```

## References

* [Picocli](https://picocli.info/) - advanced command line parser
* [WordPuzzle - Haskell](https://github.com/frankhjung/haskell-wordpuzzle) - Haskell solution to the 9 Letter Word Puzzle
