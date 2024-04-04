package pl.edu.pwr.ztw.books.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwr.ztw.books.Author.Author;
import pl.edu.pwr.ztw.books.Author.IAuthorService;
import pl.edu.pwr.ztw.books.Database.IDatabaseService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class BooksService implements IBooksService {
    @Autowired
    IDatabaseService dbService;

    @Override
    public Collection<Book> getBooks() {
        return dbService.getBooks();
    }

    @Override
    public Book getBook(int id) {
        return dbService.getBooks().stream()
                .filter(b -> b.getId() == id)
                .findAny()
                .orElse(null);
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
