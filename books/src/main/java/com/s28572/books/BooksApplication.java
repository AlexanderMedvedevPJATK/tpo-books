package com.s28572.books;

import com.s28572.books.Controllers.AuthorController;
import com.s28572.books.Controllers.BookController;
import com.s28572.books.Controllers.PublisherController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class BooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(AuthorController authorController,
                                    BookController bookController,
                                    PublisherController publisherController) {

        return runner -> {
            Scanner scanner = new Scanner(System.in);
            int choice;
            boolean running = true;
            while (running){
                 try {
                    System.out.println("Choose an option: ");
                    System.out.println("1. Add author");
                    System.out.println("2. Add publisher");
                    System.out.println("3. Add book");
                    System.out.println("4. Show authors");
                    System.out.println("5. Show publishers");
                    System.out.println("6. Show books");
                    System.out.println("0. Exit");

                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            authorController.addAuthor();
                            break;
                        case 2:
                            publisherController.addPublisher();
                            break;
                        case 3:
                            bookController.addBook();
                            break;
                        case 4:
                            authorController.showAuthors();
                            break;
                        case 5:
                            publisherController.showPublishers();
                            break;
                        case 6:
                            bookController.showBooks();
                            break;
                        case 0:
                            running = false;
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input");
                }
            }
        };
    }

}
