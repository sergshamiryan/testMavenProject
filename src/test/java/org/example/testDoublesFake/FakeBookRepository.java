package org.example.testDoublesFake;

import org.example.testDoublesFake.Book;
import org.example.testDoublesFake.BookRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FakeBookRepository implements BookRepository {

    HashMap<String, Book> db = new HashMap<>();

    @Override
    public void save(Book book) {
        db.put(book.getId(), book);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(db.values());
    }
}
