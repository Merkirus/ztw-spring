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
        booksRepo.add(new Book(1, "Potop", 1, 936));
        booksRepo.add(new Book(2, "Wesele", 2, 150));
        booksRepo.add(new Book(3, "Dziady", 3, 292));
        usersRepo.add(new User(1, "Adam"));
        usersRepo.add(new User(2, "Magda"));
        usersRepo.add(new User(3, "Tadeusz"));
        rentalRepo.add(new Rental(1, 0, 0, LocalDate.of(2024, 4, 3), false));
        rentalRepo.add(new Rental(2, 1, 1, LocalDate.of(2024, 3, 21), false));
        rentalRepo.add(new Rental(3, 2, 2, LocalDate.of(2024, 3, 11), true));
    }

    @Override
    public void addAuthor(Author author) {
        authorsRepo.add(author);
    }

    @Override
    public void addBook(Book book) {
        Integer _author = book.getAuthorId();
        if (_author != null) {
            checkAuthor(_author); // throws error
        }
        booksRepo.add(book);
    }

    @Override
    public void addRental(Rental rental) {
        Integer _book = rental.getBookId();
        if (_book != null) {
            checkBook(_book);
        }
        Integer _user = rental.getUserId();
        if (_user != null) {
            checkUser(_user);
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
        int index = authorsRepo.indexOf(checkAuthor(id));
        if (index != -1)
            authorsRepo.set(index, author);
    }

    @Override
    public void updateBook(int id, Book book) {
        int index = booksRepo.indexOf(checkBook(id));
        Integer _author = book.getAuthorId();
        if (_author != null) {
            checkAuthor(_author);
        }
        if (index != -1)
            booksRepo.set(index, book);
    }

    @Override
    public void updateRental(int id, Rental rental) {
        int index = rentalRepo.indexOf(checkRental(id));
        Integer _book = rental.getBookId();
        if (_book != null) {
            checkBook(_book);
        }
        Integer _user = rental.getUserId();
        if (_user != null) {
            checkUser(_user);
        }
        if (index != -1)
            rentalRepo.set(index, rental);
    }

    @Override
    public void updateUser(int id, User user) {
        int index = usersRepo.indexOf(checkUser(id));
        if (index != -1)
            usersRepo.set(index, user);
    }

    @Override
    public void deleteAuthor(int id) {
        checkAuthor(id);
        authorsRepo.removeIf(a -> a.getId() == id);
        booksRepo.forEach(b -> {
            if(b.getId() == id) {
                b.setAuthorId(null);
            }
        });
    }

    @Override
    public void deleteBook(int id) {
        checkBook(id);
        booksRepo.removeIf(b -> b.getId() == id);
        rentalRepo.forEach(b -> {
            if(b.getId() == id) {
                b.setBookId(null);
            }
        });
    }

    @Override
    public void deleteRental(int id) {
        checkRental(id);
        rentalRepo.removeIf(b -> b.getId() == id);
    }

    @Override
    public void deleteUser(int id) {
        checkUser(id);
        usersRepo.removeIf(b -> b.getId() == id);
        rentalRepo.forEach(b -> {
            if(b.getId() == id) {
                b.setUserId(null);
            }
        });
    }

    public Author checkAuthor(int id) {
        return authorsRepo.stream()
                .filter(a -> a.getId() == id)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Author with id = " + id + " not found"));
    }

    public Book checkBook(int id) {
        return booksRepo.stream()
                .filter(a -> a.getId() == id)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Book with id = " + id + " not found"));
    }

    public Rental checkRental(int id) {
        return rentalRepo.stream()
                .filter(a -> a.getId() == id)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Rental with id = " + id + " not found"));
    }

    public User checkUser(int id) {
        return usersRepo.stream()
                .filter(a -> a.getId() == id)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("User with id = " + id + " not found"));
    }
}
