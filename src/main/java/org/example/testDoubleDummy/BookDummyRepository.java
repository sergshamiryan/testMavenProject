package org.example.testDoubleDummy;

import java.util.List;

public interface BookDummyRepository {

    void save(BookDummy book);

     List<BookDummy> findAll();


}
