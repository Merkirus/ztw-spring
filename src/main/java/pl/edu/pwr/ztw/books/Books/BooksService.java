package pl.edu.pwr.ztw.books.Books;

import org.springframework.stereotype.Service;
import pl.edu.pwr.ztw.books.Database.IDatabaseService;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
public class BooksService implements IBooksService {
    //@Autowired
    private final IDatabaseService dbService;

    public BooksService(IDatabaseService dbService) {
        this.dbService = dbService;
    }

    @Override
    public Collection<Book> getBooks() {
        return dbService.getBooks();
    }

    @Override
    public Book getBook(int id) {
        return dbService.getBooks().stream()
                .filter(b -> b.getId() == id)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Book with id = " + id + " not found"));
    }

    @Override
    public void addBook(Book book) {
        dbService.addBook(book);
    }

    @Override
    public void updateBook(int id, Book book) {
        dbService.updateBook(id, book);
    }

    @Override
    public void deleteBook(int id) {
        dbService.deleteBook(id);
    }
}
