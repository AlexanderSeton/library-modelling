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

    public boolean checkSpace() {
        return capacity - this.countBooks() > 0;
    }

}
