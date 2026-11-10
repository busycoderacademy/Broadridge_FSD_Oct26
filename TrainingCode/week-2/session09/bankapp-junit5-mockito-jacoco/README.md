# Bank Application — JUnit 5, Mockito and JaCoCo

A small Java 21 / Maven project based on the supplied Bank Application. It deliberately uses **no Spring Boot**. Dependencies are wired manually through constructors.

## What is included

1. **Repository unit tests** — JUnit 5 with the real `AccountRepoMapImpl`.
2. **Service unit tests** — JUnit 5 + Mockito (`@Mock`, `@InjectMocks`, stubbing, verification, `InOrder`).
3. **Integration tests** — real `AccountServiceImpl` + real `AccountRepoMapImpl`; no Mockito and no Spring.
4. **JaCoCo** — HTML, XML and CSV coverage reports.
5. Positive and negative tests for deposit, withdraw, transfer, missing accounts, invalid amounts and insufficient funds.

## Requirements

- JDK 21
- Maven 3.9+
- IntelliJ IDEA (optional)

## Run all tests

From the project root:

```bash
mvn clean test
```

## Generate JaCoCo coverage report

```bash
mvn clean verify
```

Open this report in a browser:

```text
target/site/jacoco/index.html
```

The XML report is at `target/site/jacoco/jacoco.xml` and CSV at `target/site/jacoco/jacoco.csv`.

In IntelliJ, reload the Maven project, then run `mvn clean verify` from the Maven tool window or terminal. The JaCoCo report is an HTML file; open `target/site/jacoco/index.html`.

## Suggested classroom demo

1. Run `mvn clean verify` and open the JaCoCo report.
2. Open `com.bankapp.service.AccountServiceImpl` in the report.
3. Temporarily comment out one test (for example, the insufficient-withdrawal test), run `mvn clean verify` again, and compare branch coverage.
4. Restore the test and show the coverage increase.
5. Explain that coverage tells which code executed, **not** whether the assertions are logically sufficient or the implementation is correct.

## Test layout

```text
src/test/java/com/bankapp/
  repo/AccountRepoMapImplTest.java
  service/AccountServiceImplTest.java
  integration/AccountServiceIntegrationTest.java
```

## Important design notes

- `AccountRepoFileImpl` is retained from the supplied project for compatibility, but its current implementation uses a `HashMap`; it does not actually persist data to a file. The training tests use `AccountRepoMapImpl`.
- The service validates positive finite amounts, checks account existence and prevents overdrafts. Transfer validates both accounts and sufficient funds before mutating either balance.
- This is a teaching sample, not production banking software. A production system should use `BigDecimal` for money, a transactional persistent repository, concurrency control/locking, audit logging and appropriate authorization.
- JaCoCo is configured to generate reports during Maven's `verify` phase. Running only `mvn test` runs tests but does not execute the report goal in this configuration.
