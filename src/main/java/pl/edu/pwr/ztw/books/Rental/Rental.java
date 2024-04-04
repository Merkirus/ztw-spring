package pl.edu.pwr.ztw.books.Rental;

import pl.edu.pwr.ztw.books.Books.Book;
import pl.edu.pwr.ztw.books.User.User;

import java.time.LocalDate;

public class Rental {
    private int id;
    private Book book;
    private User user;
    private LocalDate date;
    private boolean isReturned;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public Rental(int id, Book book, User user, LocalDate date, boolean isReturned) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.date = date;
        this.isReturned = isReturned;
    }
}
