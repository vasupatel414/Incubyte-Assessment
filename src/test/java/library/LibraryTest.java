package library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private Library library;
    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("1234567890", "Java Programming", "Vasu Patel", 2024);
        book2 = new Book("0987654321", "Python Programming", "Vasu Kansagara", 2023);
    }

    @Test
    public void testAddBook() {
        library.addBook(book1);
        List<Book> availableBooks = library.viewAvailableBooks();
        assertEquals(1, availableBooks.size());
        assertEquals("1234567890", availableBooks.get(0).getIsbn());
    }

    @Test
    public void testBorrowBookSuccessfully() throws Exception {
        library.addBook(book1);
        library.borrowBook("1234567890");
        assertFalse(book1.isAvailable());
    }

    @Test
    public void testBorrowUnavailableBook() {
        assertThrows(Exception.class, () -> {
            library.borrowBook("1111111111"); // Book not in the library
        });
    }

    @Test
    public void testReturnBookSuccessfully() throws Exception {
        library.addBook(book1);
        library.borrowBook("1234567890");
        library.returnBook("1234567890");
        assertTrue(book1.isAvailable());
    }

    @Test
    public void testViewAvailableBooks() {
        library.addBook(book1);
        library.addBook(book2);
        List<Book> availableBooks = library.viewAvailableBooks();
        assertEquals(2, availableBooks.size());
    }

}