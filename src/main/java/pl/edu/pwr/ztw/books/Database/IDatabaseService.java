package pl.edu.pwr.ztw.books.Database;

import pl.edu.pwr.ztw.books.Author.Author;
import pl.edu.pwr.ztw.books.Books.Book;
import pl.edu.pwr.ztw.books.Rental.Rental;
import pl.edu.pwr.ztw.books.User.User;

import java.util.Collection;

public interface IDatabaseService {
    abstract public void addAuthor(Author author);
    abstract public void addBook(Book author);
    abstract public void addRental(Rental rental);
    abstract public void addUser(User user);

    abstract public Collection<Author> getAuthors();
    abstract public Collection<Book> getBooks();
    abstract public Collection<Rental> getRentals();
    abstract public Collection<User> getUsers();
    abstract public void updateAuthor(int id, Author author);
    abstract public void updateBook(int id, Book book);
    abstract public void updateRental(int id, Rental rental);
    abstract public void updateUser(int id, User user);
    abstract public void deleteAuthor(int id);
    abstract public void deleteBook(int id);
    abstract public void deleteRental(int id);
    abstract public void deleteUser(int id);
}
