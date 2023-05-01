package org.example.testDoublesDummy;

import org.example.testDoubleDummy.BookDummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookDummyRepository implements org.example.testDoubleDummy.BookDummyRepository {

    HashMap<String, BookDummy> db = new HashMap<>();

    @Override
    public void save(BookDummy book) {
        db.put(book.getId(), book);
    }

    @Override
    public List<BookDummy> findAll() {
        return new ArrayList<>(db.values());
    }
}
