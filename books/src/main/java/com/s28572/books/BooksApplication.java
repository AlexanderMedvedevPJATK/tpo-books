package com.s28572.books;

import com.s28572.books.Controllers.AuthorController;
import com.s28572.books.Controllers.BookController;
import com.s28572.books.Controllers.PublisherController;
import com.s28572.books.Entities.Author;
import com.s28572.books.Entities.Book;
import com.s28572.books.Entities.Publisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

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
            bookController.addBook();
        };
    }

}
