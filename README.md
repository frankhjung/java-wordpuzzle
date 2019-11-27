# Java Solution to 9 Letter Word Puzzle

Explore Java Streams to solve [9 Letter word Puzzle](https://nineletterword.tompaton.com/adevcrsoi/).

See also the other language solutions:
 
* [Haskell](https://gitlab.com/frankhjung1/haskell-wordpuzzle)
* [Java](https://gitlab.com/frankhjung1/java-wordpuzzle)
* [Python](https://gitlab.com/frankhjung1/python-wordpuzzle)

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
WordPuzzleApp 1.0.1
```

### Run

Run puzzle solution over reference data:

```bash
mvn exec:java -Dexec.mainClass=com.marlo.games.WordPuzzleApp -Dexec.args="-m c -l adevcrsoi"
java -cp target/com.marlo.games-wordpuzzle.jar com.marlo.games.WordPuzzleApp -m c -l adevcrsoi
```

## References

* [Hibernate Validator](https://hibernate.org/validator/documentation/getting-started/) - validate command line arguments
* [Junit-QuickCheck](https://github.com/pholser/junit-quickcheck)
* [Picocli](https://picocli.info/) - advanced command line parser
* [WordPuzzle - Haskell](https://github.com/frankhjung/haskell-wordpuzzle) - Haskell solution to the 9 Letter Word Puzzle
