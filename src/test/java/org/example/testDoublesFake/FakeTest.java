package org.example.testDoublesFake;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FakeTest {

    @Test
    public void testFake(){
        BookService bookService = new BookService(new FakeBookRepository());
        bookService.addBook(new Book("one","John Conor",1000, LocalDate.now()));
        assertEquals(2,bookService.findNumberAllBooks());
    }

}
