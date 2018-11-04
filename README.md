# quinn-java

Java bindings for the native Rust [quinn](https://github.com/djc/quinn) crate, via the `quinn-ffi` crate.

## Prerequisites

### Rust

Rust must be installed:

```console
$ curl https://sh.rustup.rs -sSf | sh
...
```

Generally it's a good idea to update Rust if already installed:

```console
$ rustup update
...
```

### Java

This project was build against [Java 1.8](https://www.java.com).
[Maven 3.6.0](https://maven.apache.org/index.html) is needed for building and testing.

## Compiling

```console
$ mvn compile
...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.728 s
[INFO] Finished at: 2018-11-04T08:25:21-08:00
[INFO] ------------------------------------------------------------------------
```

## Testing

```console
$ mvn test
...
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  5.455 s
[INFO] Finished at: 2018-11-04T08:24:22-08:00
[INFO] ------------------------------------------------------------------------
```

## Deploying

TBD