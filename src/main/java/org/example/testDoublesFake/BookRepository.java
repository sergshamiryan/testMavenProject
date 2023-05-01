package org.example.testDoublesFake;

import java.util.List;

public interface BookRepository {

    void save(Book book);

     List<Book> findAll();


}
