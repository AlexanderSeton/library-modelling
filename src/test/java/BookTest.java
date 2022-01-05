import org.junit.Before;

public class BookTest {

    private Book book1;

    @Before
    public void before() {
        book1 = new Book("Atomic Habits", "James Clear", "Self Help");
    }

}
