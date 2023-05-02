package org.example.testDoublesDummy;

import org.example.testDoubleDummy.BookDummy;
import org.example.testDoubleDummy.BookDummyService;
import org.example.testDoublesFake.Book;
import org.example.testDoublesFake.BookService;
import org.example.testDoublesFake.FakeBookRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DummyTest {

    @Test
    public void demoDummy() {
        // We have created and provided DummyEmailService because of constructor, just for code to compile
        BookDummyService bookService = new BookDummyService(new BookDummyRepository(), new DummyEmailService());

        bookService.addBook(new BookDummy("one", "John Conor", 1000, LocalDate.now()));
        assertEquals(1, bookService.findNumberAllBooks());
    }

    @Test
    public void demoDummyWIthMockito() {
        FakeBookRepository fakeBookRepository = mock(FakeBookRepository.class);
        DummyEmailService dummyEmailService = mock(DummyEmailService.class);

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

}
