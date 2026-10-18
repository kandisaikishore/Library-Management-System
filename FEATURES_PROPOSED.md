# Library Management System: Feature Enhancements

This branch proposes a focused enhancement of the existing plain-Java console application.

## Planned features
- Search catalogue records by title, author, ISBN, or ID.
- Validate required fields and positive identifiers.
- Reject duplicate book/member identifiers and duplicate ISBN values.
- Record 14-day loan due dates and report overdue loans.
- Ensure only the member who borrowed a book can return it.
- Add regression tests for lending and validation edge cases.
- Provide an interactive menu instead of a hard-coded demonstration sequence.

## Implementation note
Preserve the current dependency-free Java architecture for now. Records remain in memory and reset when the process exits; database persistence, authentication, and browser UI are separate future milestones.