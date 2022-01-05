import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {

    private Borrower borrower;
    private Book book1;
    private Book book2;

    @Before
    public void before() {
        borrower = new Borrower();
        book1 = new Book("Atomic Habits", "James Clear", "Self Help");
        book2 = new Book("American Marxism", "Mark Levin", "Historical");
    }

    @Test
    public void canBorrowBook() {
        borrower.borrowBook(book1);
        assertEquals(1, borrower.countBooks());
    }

    @Test
    public void canReturnBook() {
        borrower.borrowBook(book1);
        borrower.borrowBook(book2);
        borrower.returnBook(book1);
        assertEquals(1, borrower.countBooks());
    }

}
