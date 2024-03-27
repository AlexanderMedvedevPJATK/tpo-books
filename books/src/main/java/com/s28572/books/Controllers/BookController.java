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
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final Scanner scanner;

    public BookController(BookService bookService, AuthorService authorService, PublisherService publisherService, Scanner scanner) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.scanner = scanner;
    }

    @Transactional
    public void addBook() {
        List<Author> authors = new ArrayList<>();
        while (authors.isEmpty()) {
             authors.add(authorService.getAuthor());
        }

        int choice = 0;
        while (choice != 2) {
            System.out.println("Do you want to add another author?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                authors.add(authorService.getAuthor());
            } else if (choice != 2) {
                System.out.println("Invalid choice");
            }
        }

        Publisher publisher = null;
        while (publisher == null) {
            publisher = publisherService.getPublisher();
        }

        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        LocalDate date;
        while (true) {
            try {
                System.out.println("Please enter a date in the format yyyy-MM-dd: ");
                String input = scanner.nextLine();
                date = LocalDate.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
            }
        }

        Book book = new Book(title, date, authors, publisher);
        authors.forEach(author -> author.addBook(book));
        bookService.save(book);
    }

    public void showBooks() {
        bookService.printBooks(bookService.showBooks());
    }
}
