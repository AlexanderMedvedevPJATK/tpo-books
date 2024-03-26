package com.s28572.books.Controllers;

import com.s28572.books.Entities.Author;
import com.s28572.books.Entities.Book;
import com.s28572.books.Entities.Publisher;
import com.s28572.books.Services.AuthorService;
import com.s28572.books.Services.BookService;
import com.s28572.books.Services.PublisherService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
@Controller
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final PublisherService publisherService;

    public BookController(BookService bookService, AuthorService authorService, PublisherService publisherService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }

    @Transactional
    public void addBook() {
        Author author = authorService.getAuthor();
        Publisher publisher = new Publisher("Publisher");
        publisherService.save(publisher);
        Book book = new Book("Title", LocalDate.now(), author, publisher);
        author.addBook(book);
        bookService.save(book);
    }
}
