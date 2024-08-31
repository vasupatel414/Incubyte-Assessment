package library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void borrowBook(String isbn) throws Exception {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    return;
                } else {
                    throw new Exception("Book is already borrowed.");
                }
            }
        }
        throw new Exception("Book not found.");
    }

    public void returnBook(String isbn) throws Exception {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    return;
                } else {
                    throw new Exception("Book was not borrowed.");
                }
            }
        }
        throw new Exception("Book not found.");
    }

}