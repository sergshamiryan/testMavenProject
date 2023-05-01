package org.example.testDoublesStub;

import java.time.LocalDate;


/**
 * Stub is written only for distinguishing classes, stubs are only in tests, these are
 * ordinary daos,services, and repositories
 */
public class BookStub {
    private String id;
    private String title;
    private  int price;
    private LocalDate publishedDate;

    public BookStub(String id, String title, int price, LocalDate publishedDate) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.publishedDate = publishedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
}
