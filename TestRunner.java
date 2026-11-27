public class TestRunner {
    static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    public static void main(String[] args) {
        Library library = new Library();
        Book book = new Book(1, "Java", "Author");
        User alice = new User(1, "Alice");
        User bob = new User(2, "Bob");

        library.addBook(book);
        library.addUser(alice);
        library.addUser(bob);

        library.issueBook(1, 1);
        check(book.isIssued(), "book should be issued");
        check(alice.hasIssuedBook(book), "the borrowing member should own the active loan");

        library.issueBook(1, 1);
        library.issueBook(1, 2);
        check(alice.toString().contains("Issued Books: 1"), "duplicate issue must not create another loan");
        check(bob.toString().contains("Issued Books: 0"), "another member must not receive an already-issued book");

        library.returnBook(1, 2);
        check(book.isIssued(), "a different member must not return the active loan");
        check(alice.hasIssuedBook(book), "failed return must preserve the actual borrower's record");
        check(bob.toString().contains("Issued Books: 0"), "failed return must not add a loan to the caller");

        library.returnBook(1, 1);
        check(!book.isIssued(), "the borrower should be able to return the book");
        check(!alice.hasIssuedBook(book), "successful return must remove the borrower's loan");

        library.returnBook(1, 1);
        check(!book.isIssued(), "duplicate return must leave the book available");

        library.issueBook(1, 2);
        check(bob.hasIssuedBook(book), "the book should be borrowable after a valid return");
        library.returnBook(1, 2);
        check(!book.isIssued(), "the second borrower should be able to return the book");

        System.out.println("Library tests passed");
    }
}
