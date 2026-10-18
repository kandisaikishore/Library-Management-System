# Library Management System — Java OOP

[![Java](https://img.shields.io/badge/Java-OOP-orange?logo=openjdk)](https://www.java.com/) [![Repository](https://img.shields.io/badge/GitHub-Source-181717?logo=github)](https://github.com/kandisaikishore/Library-Management-System) [![Last Commit](https://img.shields.io/github/last-commit/kandisaikishore/Library-Management-System)](https://github.com/kandisaikishore/Library-Management-System/commits/main)

A learning-oriented Java application that models library operations such as tracking books and members, and issuing and returning books. It is intended to demonstrate object-oriented programming in a small, understandable codebase.

## Capabilities

- Represent book and library data with Java classes
- Track book availability and lending actions where implemented
- Add and manage library records
- Practise encapsulation, abstraction, and class relationships
- Explore a simple command-line workflow

## Tech stack

- Java / JDK
- Object-oriented programming

## Prerequisites

Install a JDK and ensure the `java` and `javac` commands are available.

## Run locally

```bash
git clone https://github.com/kandisaikishore/Library-Management-System.git
cd Library-Management-System
javac *.java
java Main
```

The command assumes default-package source files and a `Main` class. If the entry point or package layout differs, use the corresponding class name and compile from the appropriate source directory.

## Current scope

Review the implementation before assuming that data persists across runs or that authentication, multi-user concurrency, or production library policies are implemented. The repository is best treated as an educational project unless those behaviours are explicitly built and tested.

## Potential enhancements

- Store records in MySQL or another database
- Search by title, author, or ISBN
- Track issue dates, due dates, and overdue books
- Validate input and prevent duplicate identifiers
- Add unit tests for issue/return edge cases

## Contributing

Please include concise reproduction steps and relevant tests with bug reports or pull requests.

## License

No license file is currently declared. Add a `LICENSE` file to define reuse terms.


## REST API and browser UI

The browser interface now calls a Java Spring Boot REST API. Install JDK 17+ and Maven, then start the API from the repository root:

```bash
cd api
mvn spring-boot:run
```

Open the UI at `http://localhost:8080/`. The API uses port 8080. API endpoints are under `/api`. Current API data is held in server memory and resets when the process restarts; configure a database before production use. The API module is separate from the original console/Swing classes, so it does not share their in-process state.
