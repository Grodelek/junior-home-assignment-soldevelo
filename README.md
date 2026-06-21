# Take-Home Task: Alert Rule Engine

A small backend component for a monitoring system. It processes integer
measurement values and produces alert labels based on a configurable set of
rules. When multiple rules match a value, their labels are concatenated in
rule order; if no rule matches, the value itself is returned.

## Requirements

- Java 17+
- Maven 3.6+

## Technologies
- Java 17
- Maven 3.6
- JUnit 5

## How to run

```bash
mvn compile exec:java
```

This prints the alert output for values 1–20.

## How to run the unit tests

```bash
mvn test
```

## Output for values 1–20

```
1
2
LOW
4
ADVISORY
LOW
7
8
LOW
ADVISORY
11
LOW
13
14
LOWADVISORY
16
17
LOW
19
ADVISORY
```

## Design

The system is built around a single abstraction:

- **`AlertRule`** — an interface with `matches(int)` and `label()`. Each rule
  decides on its own whether it applies to a value and what label it produces.
- **`DivisibleByRule`** — a concrete rule that matches when a value is
  divisible by a given divisor and returns a given label.
- **The engine** (`Main.combine`) — iterates over a list of rules in order,
  concatenates the labels of all matching rules, and falls back to the number
  itself when none match.

Because the engine depends only on the `AlertRule` interface and never on a
specific rule type, it knows nothing about divisibility. Adding a new rule
does not require changing the engine or any existing rule.

## Adding a new rule

Adding a rule is a single line. For example, the `WARN` rule (divisible by 7):

```java
List<AlertRule> rules = List.of(
        new DivisibleByRule(3, "LOW"),
        new DivisibleByRule(5, "ADVISORY"),
        new DivisibleByRule(7, "WARN")   // <-- new rule, nothing else changes
);
```

The order of the list defines the order in which labels are concatenated.

## Examples (with the WARN rule)

| Value | Output            |
|-------|-------------------|
| 21    | `LOWWARN`         |
| 35    | `ADVISORYWARN`    |
| 105   | `LOWADVISORYWARN` |
