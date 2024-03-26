package com.s28572.books.Services;

import com.s28572.books.Entities.Book;
import com.s28572.books.Repositories.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void save(Book book) {
        bookRepository.save(book);
        System.out.println("Book saved");
        System.out.println(bookRepository.findAll());
    }
}
