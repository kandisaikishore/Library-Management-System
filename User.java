// User.java
import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private List<Book> issuedBooks;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public void issueBook(Book book) {
        if (book != null && !issuedBooks.contains(book)) {
            issuedBooks.add(book);
        }
    }

    public boolean hasIssuedBook(Book book) {
        return issuedBooks.contains(book);
    }

    public void returnBook(Book book) {
        issuedBooks.remove(book);
    }

    @Override
    public String toString() {
        return id + " - " + name + " | Issued Books: " + issuedBooks.size();
    }
}
