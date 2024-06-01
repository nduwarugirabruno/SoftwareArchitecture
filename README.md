# COFODY

### WE TAKE THE NEXT STEP TOGETHER

[![COFODY](.assets/images/cofody-removebg-preview.png)](https://github.com/nduwarugirabruno/COFODY)

COFODY est une application de gestion des caisses d’une tontine. Cette application vise à faciliter la création, la gestion et le suivi des caisses au sein de la COFODY.

It can be previewed on my [GitHub](https://github.com/nduwarugirabruno/COFODY) repository.

## Getting Started

To start building, clone this repository:

```bash
git clone https://github.com/nduwarugirabruno/COFODY.git
```

Once cloned, run the following to install dependencies and run the app:

```bash
cd /path/to/the/cloned/repository/folder
# open with your code editor for exemple IntelliJ IDEA or Visual Studio Code
idea ./
```

## Structure

We have 4 sub folders and the readme file:

```bash
links@links:~/IdeaProjects/COFODY$ ls
    CAISSE  EurekaServer  README.md  REUNION  USER
```

- The first folder [AHP](AHP) is the Caisse Service developed in Spring Boot x Spring Cloud framework.
- The first folder [TP](TP) is the Caisse Service developed in Spring Boot x Spring Cloud framework.

## Execution

To execute the project, run:

```bash
links@links:~/IdeaProjects/COFODY$ mvn spring-boot:run
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------< io.nokash.app:COFODY >------------------------
[INFO] Building COFODY 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] >>> spring-boot-maven-plugin:3.2.3:run (default-cli) > test-compile @ COFODY >>>
     .
     .
     .
2024-03-07T13:28:24.502+01:00  INFO 55957 --- [  restartedMain] io.nokash.app.cofody.CofodyApplication   : Started CofodyApplication in 18.329 seconds (process running for 21.339)
```

## Production

To build for production, run:

```bash
links@links:~/IdeaProjects/COFODY$ mvn clean package
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------< io.nokash.app:COFODY >------------------------
[INFO] Building COFODY 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
     .
     .
     .
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  02:09 min
[INFO] Finished at: 2024-03-07T13:26:33+01:00
[INFO] ------------------------------------------------------------------------
```

## Unit Tests

To run the unit tests once, run:

```bash
links@links:~/IdeaProjects/COFODY$ mvn clean test
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------< io.nokash.app:COFODY >------------------------
[INFO] Building COFODY 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
     .
     .
     .
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 36.03 s -- in io.nokash.app.cofody.CofodyApplicationTests
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  49.991 s
[INFO] Finished at: 2024-03-07T13:35:36+01:00
[INFO] ------------------------------------------------------------------------
```
