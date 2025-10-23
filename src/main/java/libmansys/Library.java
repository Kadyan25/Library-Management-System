package libmansys;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
        System.out.println("Book added!");
    }

    public void addUser(User u) {
        users.add(u);
        System.out.println("User added!");
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void showUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }
        for (User u : users) {
            System.out.println(u);
        }
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        if (book.isIssued()) {
            System.out.println("Book already issued.");
            return;
        }
        book.setIssued(true);
        System.out.println("Book issued to " + user.getName());
    }

    public void returnBook(int bookId) {
        Book book = findBook(bookId);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (!book.isIssued()) {
            System.out.println("Book was not issued.");
            return;
        }
        book.setIssued(false);
        System.out.println("Book returned!");
    }

    private Book findBook(int id) {
        for (Book b : books) {
            if (b.getId() == id)
                return b;
        }
        return null;
    }

    private User findUser(int id) {
        for (User u : users) {
            if (u.getId() == id)
                return u;
        }
        return null;
    }
}
