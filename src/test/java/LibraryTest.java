import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {

    private Library library;
    private Library smallLibrary;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;

    @Before
    public void before() {
        library = new Library(5);
        smallLibrary = new Library(2);
        book1 = new Book("Atomic Habits", "James Clear", "Self Improvement");
        book2 = new Book("American Marxism", "Mark Levin", "Historical");
        book3 = new Book("The Four Agreements", "Miguel Ruiz", "Self Improvement");
        book4 = new Book("If Animals Kissed Good Night", "Ann Paul", "Children");
    }

    @Test
    public void canCountBooks() {
        library.addBook(book1);
        library.addBook(book3);
        assertEquals(2, library.countBooks());
    }

    @Test
    public void canAddBook() {
        library.addBook(book1);
        assertEquals(1, library.countBooks());
    }

    @Test
    public void canCheckIfSpaceForOneBook() {
        assertTrue(library.checkSpace());
    }

    @Test
    public void canAddBooksUpToCapacity() {
        smallLibrary.addBook(book1);
        smallLibrary.addBook(book2);
        smallLibrary.addBook(book3);
        assertFalse(smallLibrary.checkSpace());
        assertEquals(2, smallLibrary.countBooks());
    }

}
