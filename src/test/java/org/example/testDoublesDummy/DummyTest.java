package org.example.testDoublesDummy;

import org.example.testDoubleDummy.BookDummy;
import org.example.testDoubleDummy.BookDummyService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyTest {

    @Test
    public void demoDummy(){
        BookDummyService bookService = new BookDummyService(new BookDummyRepository(), new DummyEmailService());

        bookService.addBook(new BookDummy("one","John Conor",1000, LocalDate.now()));

        assertEquals(1,bookService.findNumberAllBooks());
    }

}
