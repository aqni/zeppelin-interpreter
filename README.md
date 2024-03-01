# IGinX Zeppelin-Interpreter
## Introduction
This is a Zeppelin-Interpreter for [IGinX](https://github.com/IGinX-THU/IGinX). It is used to connect IGinX with [Apache Zeppelin](https://zeppelin.apache.org/).

## Build
To build the library from source, run the following command:
```shell
mvn clean package -DskipTests -P get-jar-with-dependencies
```

## Usage
1. Copy the jar file `zeppelin-iginx-0.6.0-SNAPSHOT-jar-with-dependencies.jar` to the `$ZEPPELIN_HOME/interpreters/iginx` directory of Zeppelin.(If the directory does not exist, create it.)
2. Then restart Zeppelin. After restarting, you can use the IGinX interpreter in Zeppelin.