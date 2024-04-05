package pl.edu.pwr.ztw.books.Rental;

import java.time.LocalDate;

public class Rental {
    private int id;
    private Integer book_id;
    private Integer user_id;
    private LocalDate date;
    private boolean isReturned;

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getBookId() {
        return book_id;
    }

    public void setBookId(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getUserId() {
        return user_id;
    }

    public void setUserId(Integer user_id) {
        this.user_id = user_id;
    }



    public Rental(int id, Integer book_id, Integer user_id, LocalDate date, boolean isReturned) {
        this.id = id;
        this.book_id = book_id;
        this.user_id = user_id;
        this.date = date;
        this.isReturned = isReturned;
    }
}
