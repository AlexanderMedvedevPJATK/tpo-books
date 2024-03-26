package com.s28572.books.Services;

import com.s28572.books.Entities.Author;
import com.s28572.books.Repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final Scanner scanner;

    public AuthorService(AuthorRepository authorRepository, Scanner scanner) {
        this.authorRepository = authorRepository;
        this.scanner = scanner;
    }

    public Author getAuthor() {
        System.out.println("Would you like to add an author or find an existing one?");
        System.out.println("1. Add author");
        System.out.println("2. Find author");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Enter author's first name:");
            String firstName = scanner.next();

            System.out.println("Enter author's last name:");
            String lastName = scanner.next();

            Author author = new Author(firstName, lastName);
            authorRepository.save(author);

            return author;
        } else if (choice == 2) {
            System.out.println("List all authors or search?");
            System.out.println("1. List all authors");
            System.out.println("2. Search for author");
            choice = scanner.nextInt();

            Author author;

            if (choice == 1) {
                author = chooseAuthor(authorRepository.findAll());
            } else {
                author = chooseAuthor(searchAuthors(scanner));
            }
            return author;
        } else {
            System.out.println("Invalid choice");
        }

        return null;
    }

    private List<Author> searchAuthors(Scanner scanner) {
        System.out.println("Search by first name or last name?");
        System.out.println("1. First name");
        System.out.println("2. Last name");
        int choice = scanner.nextInt();
        List<Author> authors;

        if (choice == 1) {
            System.out.println("Enter author's first name:");
            String firstName = scanner.next();
            authors = authorRepository.findByFirstName(firstName);
        } else if (choice == 2) {
            System.out.println("Enter author's last name:");
            String lastName = scanner.next();
            authors = authorRepository.findByLastName(lastName);

        } else {
            System.out.println("Invalid choice");
            return null;
        }

        return authors;
    }

    public Author chooseAuthor(List<Author> authors) {
        if (authors == null || authors.isEmpty()) {
            System.out.println("No authors found");
            return null;
        }
        for (int i = 0; i < authors.size(); i++) {
            System.out.println((i + 1) + ". " + authors.get(i));
        }
        System.out.println("Choose author:");
        int choice = scanner.nextInt();
        if (choice < 1 || choice > authors.size()) {
            System.out.println("Invalid choice");
            return null;
        }
        return authors.get(choice - 1);
    }
}
