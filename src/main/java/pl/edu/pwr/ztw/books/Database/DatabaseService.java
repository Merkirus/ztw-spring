package pl.edu.pwr.ztw.books.Database;

import org.springframework.stereotype.Service;
import pl.edu.pwr.ztw.books.Author.Author;
import pl.edu.pwr.ztw.books.Books.Book;
import pl.edu.pwr.ztw.books.Rental.Rental;
import pl.edu.pwr.ztw.books.User.User;

import java.time.LocalDate;
import java.util.*;

@Service
public class DatabaseService implements IDatabaseService {
    private static List<Author> authorsRepo = new ArrayList<>();
    private static List<Book> booksRepo = new ArrayList<>();
    private static List<Rental> rentalRepo = new ArrayList<>();

    private static List<User> usersRepo = new ArrayList<>();

    static {
        authorsRepo.add(new Author(1, "Henryk", "Sienkiewicz"));
        authorsRepo.add(new Author(2, "Stanisław", "Reymont"));
        authorsRepo.add(new Author(3, "Adam", "Mickiewicz"));
        booksRepo.add(new Book(1, "Potop", authorsRepo.stream().filter(a -> Objects.equals(a.getSurname(), "Sienkiewicz")).findAny().orElse(null), 936));
        booksRepo.add(new Book(2, "Wesele", authorsRepo.stream().filter(a -> Objects.equals(a.getSurname(), "Reymont")).findAny().orElse(null), 150));
        booksRepo.add(new Book(3, "Dziady", authorsRepo.stream().filter(a -> Objects.equals(a.getSurname(), "Mickiewicz")).findAny().orElse(null), 292));
        usersRepo.add(new User(1, "Adam"));
        usersRepo.add(new User(2, "Magda"));
        usersRepo.add(new User(3, "Tadeusz"));
        rentalRepo.add(new Rental(1, booksRepo.get(0), usersRepo.get(0), LocalDate.of(2024, 4, 3), false));
        rentalRepo.add(new Rental(2, booksRepo.get(1), usersRepo.get(1), LocalDate.of(2024, 3, 21), false));
        rentalRepo.add(new Rental(3, booksRepo.get(2), usersRepo.get(2), LocalDate.of(2024, 3, 11), true));
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
        Book _book = rental.getBook();
        if (_book != null && !booksRepo.contains(_book)) {
            booksRepo.add(_book);
        }
        User _user = rental.getUser();
        if (_user != null && !usersRepo.contains(_user)) {
            usersRepo.add(_user);
        }

        rentalRepo.add(rental);
    }

    @Override
    public void addUser(User user) {
        usersRepo.add(user);
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
        return rentalRepo;
    }

    @Override
    public Collection<User> getUsers() {
        return usersRepo;
    }

    @Override
    public void updateAuthor(int id, Author author) {
        int index = authorsRepo.indexOf(authorsRepo.stream()
                .filter(a -> a.getId() == id)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Author with id = " + id + " not found")));
        if (index != -1)
            authorsRepo.set(index, author);
    }

    @Override
    public void updateBook(int id, Book book) {
        int index = booksRepo.indexOf(booksRepo.stream()
                .filter(b -> b.getId() == id)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Book with id = " + id + " not found")));
        if (index != -1)
            booksRepo.set(index, book);
    }

    @Override
    public void updateRental(int id, Rental rental) {
        int index = rentalRepo.indexOf(rentalRepo.stream()
                .filter(b -> b.getId() == id)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Rental with id = " + id + " not found")));
        if (index != -1)
            rentalRepo.set(index, rental);
    }

    @Override
    public void updateUser(int id, User user) {
        int index = usersRepo.indexOf(usersRepo.stream()
                .filter(b -> b.getId() == id)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("User with id = " + id + " not found")));
        if (index != -1)
            usersRepo.set(index, user);
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
        rentalRepo.forEach(b -> {
            if(b.getId() == id) {
                b.setBook(null);
            }
        });
    }

    @Override
    public void deleteRental(int id) {
        rentalRepo.removeIf(b -> b.getId() == id);
    }

    @Override
    public void deleteUser(int id) {
        usersRepo.removeIf(b -> b.getId() == id);
        rentalRepo.forEach(b -> {
            if(b.getId() == id) {
                b.setUser(null);
            }
        });
    }
}
