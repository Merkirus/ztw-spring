package pl.edu.pwr.ztw.books.Database;

import org.springframework.stereotype.Service;
import pl.edu.pwr.ztw.books.Author.Author;
import pl.edu.pwr.ztw.books.Books.Book;
import pl.edu.pwr.ztw.books.Rental.Rental;
import pl.edu.pwr.ztw.books.User.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
public class DatabaseService implements IDatabaseService {
    private static List<Author> authorsRepo = new ArrayList<>();
    private static List<Book> booksRepo = new ArrayList<>();
    private static List<Rental> rentalRepo = new ArrayList<>();

    static {
        authorsRepo.add(new Author(1, "Henryk", "Sienkiewicz"));
        authorsRepo.add(new Author(2, "Stanisław", "Reymont"));
        authorsRepo.add(new Author(3, "Adam", "Mickiewicz"));
        booksRepo.add(new Book(1, "Potop", authorsRepo.stream().filter(a -> Objects.equals(a.getSurname(), "Sienkiewicz")).findAny().orElse(null), 936));
        booksRepo.add(new Book(2, "Wesele", authorsRepo.stream().filter(a -> Objects.equals(a.getSurname(), "Reymont")).findAny().orElse(null), 150));
        booksRepo.add(new Book(3, "Dziady", authorsRepo.stream().filter(a -> Objects.equals(a.getSurname(), "Mickiewicz")).findAny().orElse(null), 292));
    }

    @Override
    public void addAuthor(Author author) {
        authorsRepo.add(author);
    }

    @Override
    public void addBook(Book book) {
        Author _author = book.getAuthor();
        if (_author != null && !authorsRepo.contains(_author)) {
            authorsRepo.add(_author);
        }
        booksRepo.add(book);
    }

    @Override
    public void addRental(Rental rental) {

    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public Collection<Author> getAuthors() {
        return authorsRepo;
    }

    @Override
    public Collection<Book> getBooks() {
        return booksRepo;
    }

    @Override
    public Collection<Rental> getRentals() {
        return null;
    }

    @Override
    public Collection<User> getUsers() {
        return null;
    }

    @Override
    public void updateAuthor(int id, Author author) {
        int index = authorsRepo.indexOf(authorsRepo.stream()
                .filter(a -> a.getId() == id)
                .findAny()
                .orElse(null));
        if (index != -1)
            authorsRepo.set(index, author);
    }

    @Override
    public void updateBook(int id, Book book) {
        int index = booksRepo.indexOf(booksRepo.stream()
                .filter(b -> b.getId() == id)
                .findAny()
                .orElse(null));
        if (index != -1)
            booksRepo.set(index, book);
    }

    @Override
    public void updateRental(int id, Rental rental) {

    }

    @Override
    public void updateUser(int id, User user) {

    }

    @Override
    public void deleteAuthor(int id) {
        authorsRepo.removeIf(a -> a.getId() == id);
        booksRepo.forEach(b -> {
            if(b.getId() == id) {
                b.setAuthor(null);
            }
        });
    }

    @Override
    public void deleteBook(int id) {
        booksRepo.removeIf(b -> b.getId() == id);
    }

    @Override
    public void deleteRental(int id) {

    }

    @Override
    public void deleteUser(int id) {

    }
}
