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
        System.out.println("2. Find an author");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            return addAuthor();
        } else if (choice == 2) {
            return chooseAuthor(showAuthors());
        } else {
            System.out.println("Invalid choice");
        }

        return null;
    }

    public List<Author> showAuthors() {
        System.out.println("List all authors or search?");
        System.out.println("1. List all authors");
        System.out.println("2. Search for author");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            return authorRepository.findAll();
        }
        if (choice == 2 ){
            return searchAuthors();
        } else {
            System.out.println("Invalid choice");
        }

        return null;
    }

    private List<Author> searchAuthors() {
        System.out.println("Search by first name or last name?");
        System.out.println("1. First name");
        System.out.println("2. Last name");
        int choice = scanner.nextInt();
        scanner.nextLine();
        List<Author> authors;

        if (choice == 1) {
            System.out.println("Enter author's first name:");
            String firstName = scanner.nextLine();
            authors = authorRepository.findByFirstNameContainingIgnoreCase(firstName);
        } else if (choice == 2) {
            System.out.println("Enter author's last name:");
            String lastName = scanner.nextLine();
            authors = authorRepository.findByLastNameContainingIgnoreCase(lastName);

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

        printAuthors(authors);

        System.out.println("Choose author:");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > authors.size()) {
            System.out.println("Invalid author choice");
            return null;
        }

        return authors.get(choice - 1);
    }

    public void printAuthors(List<Author> authors) {
        for (int i = 0; i < authors.size(); i++) {
            System.out.println((i + 1) + ". " + authors.get(i));
        }
    }

    public Author addAuthor() {
        System.out.println("Enter author's first name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter author's last name:");
        String lastName = scanner.nextLine();

        Author author = new Author(firstName, lastName);
        authorRepository.save(author);

        return author;
    }
}
