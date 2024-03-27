package com.s28572.books.Controllers;

import com.s28572.books.Services.AuthorService;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    public void showAuthors() {
        authorService.printAuthors(authorService.showAuthors());
    }

    public void addAuthor() {
        authorService.addAuthor();
    }
}
