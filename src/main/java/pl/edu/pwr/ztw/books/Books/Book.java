package pl.edu.pwr.ztw.books.Books;

import java.util.Objects;

public class Book {
    private int id;
    private String title;
    private Integer authorId;
    int pages;

    public Book(int id, String title, Integer authorId, int pages) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.pages = pages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer author_id) {
        this.authorId = author_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && pages == book.pages && Objects.equals(title, book.title) && Objects.equals(authorId, book.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, authorId, pages);
    }
}
