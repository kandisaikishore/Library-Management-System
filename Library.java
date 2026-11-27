// Library.java
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book b) { books.add(b); }
    public void addUser(User u) { users.add(u); }

    public void issueBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book != null && user != null && !book.isIssued()) {
            book.setIssued(true);
            user.issueBook(book);
            System.out.println("Book issued successfully!");
        } else {
            System.out.println("Book cannot be issued.");
        }
    }

    public void returnBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        // Only the member who borrowed this book may return it.
        if (book != null && user != null && book.isIssued() && user.hasIssuedBook(book)) {
            user.returnBook(book);
            book.setIssued(false);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Return failed.");
        }
    }

    private Book findBook(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

    private User findUser(int id) {
        return users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    public void displayBooks() {
        books.forEach(System.out::println);
    }

    public void displayUsers() {
        users.forEach(System.out::println);
    }
}
