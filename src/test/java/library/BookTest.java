package library;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testBookCreation() {
        Book book = new Book("1234567890", "Java Programming", "Vasu Patel", 2024);
        assertEquals("1234567890", book.getIsbn());
        assertEquals("Java Programming", book.getTitle());
        assertEquals("Vasu Patel", book.getAuthor());
        assertEquals(2024, book.getPublicationYear());
        assertTrue(book.isAvailable()); // Initially, the book should be available
    }
}