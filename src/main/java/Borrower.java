import java.util.ArrayList;

public class Borrower {

    private ArrayList<Book> books;

    public Borrower() {
        this.books = new ArrayList<>();
    }

    public int countBooks() {
        return this.books.size();
    }

    public void borrowBook(Book book) {
        this.books.add(book);
    }

    public Book returnBook(Book book) {
        this.books.remove(book);
        return book;
    }

}
