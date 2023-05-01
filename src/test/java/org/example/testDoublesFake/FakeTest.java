package org.example.testDoublesFake;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FakeTest {

    @Test
    public void testFake() {
        BookService bookService = new BookService(new FakeBookRepository());
        bookService.addBook(new Book("one", "John Conor", 1000, LocalDate.now()));
        assertEquals(2, bookService.findNumberAllBooks());
    }

    @Test
    public void testFakeWithMockito() {
        FakeBookRepository fakeBookRepository = mock(FakeBookRepository.class);
        BookService bookService = new BookService(fakeBookRepository);
        Book book = new Book("1", "Name", 250, LocalDate.now());
        Book book2 = new Book("2", "name2", 150, LocalDate.now());
        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book2);

        //Stubbing - means predefined answers
        when(fakeBookRepository.findAll()).thenReturn(books);

        assertEquals(2, bookService.findNumberAllBooks());

    }

}
