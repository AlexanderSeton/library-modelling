import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private ArrayList<Book> books;
    private int capacity;
    private HashMap<String, Integer> booksByGenre;

    public Library(int capacity) {
        this.books = new ArrayList<>();
        this.capacity = capacity;
        this.booksByGenre = new HashMap<>();
    }

    public void generateHashMap() {
        HashMap<String, Integer> booksByGenre = new HashMap<>();
        for (int i=0; i<this.countBooks(); i++) {
            String genreKey = this.books.get(i).getGenre();
            if (booksByGenre.containsKey(genreKey)) {
                booksByGenre.put(genreKey, booksByGenre.get(genreKey) + 1);
            }
            else {
                booksByGenre.put(this.books.get(i).getGenre(), 1);
            }
        }
        this.booksByGenre = booksByGenre;
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

    public HashMap<String, Integer> getGenreHashMap() {
        return this.booksByGenre;
    }

}
