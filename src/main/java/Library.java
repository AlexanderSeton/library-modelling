import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private int capacity;

    public Library(int capacity) {
        this.books = new ArrayList<>();
        this.capacity = capacity;
    }

    public int countBooks() {
        return this.books.size();
    }

    public void addBook(Book book) {
        if (this.checkSpace()) {
            this.books.add(book);
        }
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    public boolean checkSpace() {
        return capacity - this.countBooks() > 0;
    }

    public void processReturn(Book book, Borrower borrower) {
        if (this.checkSpace()) {
            borrower.returnBook(book);
            this.addBook(book);
        }
    }

    public void lendOutBook(Book book, Borrower borrower) {
        if (this.books.contains(book)) {
            this.removeBook(book);
            borrower.borrowBook(book);
        }
    }

}
