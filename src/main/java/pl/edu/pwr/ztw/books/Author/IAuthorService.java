package pl.edu.pwr.ztw.books.Author;

import java.util.Collection;

public interface IAuthorService {
    public abstract Collection<Author> getAuthors();
    public abstract Author getAuthor(int id);
    public abstract void addAuthor(Author author);
    public abstract void updateAuthor(int id, Author author);
    public abstract void deleteAuthor(int id);
}
