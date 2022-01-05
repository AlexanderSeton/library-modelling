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
    private Book book5;
    private Borrower borrower;

    @Before
    public void before() {
        library = new Library(5);
        smallLibrary = new Library(2);
        book1 = new Book("Atomic Habits", "James Clear", "Self Improvement");
        book2 = new Book("American Marxism", "Mark Levin", "Historical");
        book3 = new Book("The Four Agreements", "Miguel Ruiz", "Self Improvement");
        book4 = new Book("If Animals Kissed Good Night", "Ann Paul", "Children");
        book5 = new Book("The Body Keeps the Score", "Bessel Van Der Kolk", "Self Improvement");
        borrower = new Borrower();
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

    @Test
    public void canRemoveBook() {
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.removeBook(book3);
        assertEquals(3, library.countBooks());
    }

    @Test
    public void canLendOutBooksToBorrowers() {
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.lendOutBook(book3, borrower);
        assertEquals(1, borrower.countBooks());
        assertEquals(3, library.countBooks());
    }

    @Test
    public void canProcessReturnedBook() {
        smallLibrary.addBook(book1);
        smallLibrary.addBook(book2);
        library.addBook(book3);
        library.lendOutBook(book3, borrower);
        smallLibrary.processReturn(book3, borrower);
        assertEquals(1, borrower.countBooks());
        assertEquals(2, smallLibrary.countBooks());
    }

    @Test
    public void hasHashMapOfBooksToGenre() {
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.generateHashMap();
        assertEquals(3, library.getGenreHashMap().size());
    }

}
