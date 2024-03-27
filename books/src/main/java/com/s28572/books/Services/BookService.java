package com.s28572.books.Services;

import com.s28572.books.Entities.Book;
import com.s28572.books.Entities.Publisher;
import com.s28572.books.Repositories.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final Scanner scanner;
    public BookService(BookRepository bookRepository, Scanner scanner) {
        this.bookRepository = bookRepository;
        this.scanner = scanner;
    }

    @Transactional
    public void save(Book book) {
        bookRepository.save(book);
        bookRepository.findAll().forEach(System.out::println);
    }

    public List<Book> showBooks() {
        System.out.println("List all books or search?");
        System.out.println("1. List all books");
        System.out.println("2. Search for a book");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            return (List<Book>) bookRepository.findAll();
        } else if (choice == 2) {
            return searchBooks();
        } else {
            System.out.println("Invalid choice");
        }

        return null;
    }

    private List<Book> searchBooks() {
        System.out.println("Enter book's title:");
        String name = scanner.nextLine();
        return bookRepository.findByTitleContainingIgnoreCase(name);
    }

    public void printBooks(List<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }
}
