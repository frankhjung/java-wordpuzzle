# Java Streams

Play with Java Streams.

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
mvn exec:java -Dexec.mainClass=com.marlo.streams.SearchFileApp -Dexec.args="-s help README.md"
java -cp target/com.marlo.streams.jar com.marlo.streams.SearchFileApp -s help README.md
```

## Examples

### Help

Print program help message:

```bash
java -cp target/com.marlo.streams.jar com.marlo.streams.SearchFileApp -h
```

```text
  $ java -cp target/com.marlo.streams.jar com.marlo.streams.SearchFileApp -h
  Usage: SearchFile [-hV] [-s=<search>] <file>
  Search file for string
        <file>              file to search
    -h, --help              Show this help message and exit.
    -s, --search=<search>   string to search for
    -V, --version           Print version information and exit.
```

### Search

Run search over file:

```bash
java -cp target/com.marlo.streams.jar com.marlo.streams.SearchFileApp -s help -f README.md
```

```text
  mvn exec:java -Dexec.mainClass=com.marlo.streams.SearchFileApp -Dexec.args="-s help README.md"
  java -cp target/com.marlo.streams.jar com.marlo.streams.SearchFileApp -s help README.md
  ### Help
  Print program help message:
      -h, --help              Show this help message and exit.
  java -cp target/com.marlo.streams.jar com.marlo.streams.SearchFileApp -s help -f README.md
    $ java -cp target/com.marlo.streams.jar com.marlo.streams.SearchFileApp -s help README.md
    mvn exec:java -Dexec.mainClass=com.marlo.streams.SearchFileApp -Dexec.args="-s help README.md"
    java -cp target/com.marlo.streams.jar com.marlo.streams.SearchFileApp -s help README.md
    ### Help
    Print program help message:
    java -cp target/com.marlo.streams.jar com.marlo.streams.SearchFileApp -s help -f README.md
```

## References

* [Picocli](https://picocli.info/) - advanced command line parser
