package org.example.testDoublesStub;

import org.example.testDoubleDummy.EmailService;

import java.util.List;

public class BookStubService {

    private BookStubRepository bookRepository;


    public BookStubService(BookStubRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(BookStub book){
        bookRepository.save(book);
    }

    public int findNumberAllBooks(){
        return bookRepository.findAll().size();
    }





}
