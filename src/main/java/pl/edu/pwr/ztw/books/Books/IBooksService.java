package pl.edu.pwr.ztw.books.Books;

import java.util.Collection;

public interface IBooksService {
    public abstract Collection<Book> getBooks();
    public abstract Book getBook(int id);
    public abstract void addBook(Book book);
    public abstract void updateBook(int id, Book book);
    public abstract void deleteBook(int id);
}
