package org.example.testDoubleDummy;

public class BookDummyService {

    private BookDummyRepository bookRepository;

    private EmailService emailService;

    public BookDummyService(BookDummyRepository bookRepository, EmailService emailService) {
        this.bookRepository = bookRepository;
        this.emailService = emailService;
    }

    public void addBook(BookDummy book){
        bookRepository.save(book);
    }

    public int findNumberAllBooks(){
        return bookRepository.findAll().size();
    }

}
