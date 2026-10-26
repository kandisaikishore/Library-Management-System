# Development and Testing Guide

This is a learning-oriented Java OOP application for library records and lending actions. Check the source before assuming persistence, authentication, or multi-user support exists.

## Prerequisites and run

Install a JDK and verify `java -version` and `javac -version`. From the repository root:

```bash
javac *.java
java Main
```

This command assumes default-package Java files and a `Main` entry point. If the package layout or class names differ, compile from the correct source directory and run the actual entry point.

## Lending rules to test

- Add and find books using the identifiers supported by the model.
- Reject duplicate identifiers if uniqueness is required.
- Issue an available book to a valid member.
- Reject issuing a book that is already on loan.
- Return an active loan and update availability exactly once.
- Reject return operations for unknown books or loans.
- Test missing input, whitespace-only names, and invalid menu choices.
- Test overdue-date boundaries if due dates are implemented.

## Data integrity

Availability should be derived consistently from book/loan state. Invalid operations must not mutate the stored records. Repeating an issue or return command must not create duplicate active loans or corrupt counts.

## Testing

If no automated test framework is configured, use a documented manual matrix first and introduce unit tests in a focused change. Tests should use synthetic members/books and must not rely on a particular console output order unless that output is the behavior being tested.

## Limitations

Do not describe this learning project as a multi-user production library system unless durable storage, authorization, concurrency handling, backup, and recovery have been implemented and verified.

## Pull-request checklist

- [ ] Include steps to reproduce the issue.
- [ ] Add tests for valid and invalid lending transitions.
- [ ] Compile the source and run the documented workflow.
- [ ] Record any unavailable checks.
- [ ] Keep the README aligned with actual behavior.
