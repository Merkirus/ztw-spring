package pl.edu.pwr.ztw.books.Author;

import org.springframework.stereotype.Service;
import pl.edu.pwr.ztw.books.Database.IDatabaseService;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
public class AuthorService implements IAuthorService {
    //@Autowired
    private final IDatabaseService dbService;

    public AuthorService(IDatabaseService dbService) {
        this.dbService = dbService;
    }

    @Override
    public Collection<Author> getAuthors() {
        return dbService.getAuthors();
    }

    @Override
    public Author getAuthor(int id) {
        return dbService.getAuthors().stream()
                .filter(a -> a.getId() == id)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Author with id = " + id + " not found"));
    }

    @Override
    public void addAuthor(Author author) {
        dbService.addAuthor(author);
    }

    @Override
    public void updateAuthor(int id, Author author) {
        dbService.updateAuthor(id, author);
    }

    @Override
    public void deleteAuthor(int id) {
        dbService.deleteAuthor(id);
    }
}
