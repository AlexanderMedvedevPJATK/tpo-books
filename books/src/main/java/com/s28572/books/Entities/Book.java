package com.s28572.books.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDate releaseDate;
    @ManyToMany
    private List<Author> authors;
    @ManyToOne
    private Publisher publisher;

    public Book() {
    }

    public Book(String title, LocalDate releaseDate, List<Author> authors, Publisher publisher) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.authors = authors;
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book: " + title + "\n" +
                "Released on: " + releaseDate + "\n" +
                "Authors: " + authors + "\n"+
                "Publisher: " + publisher;
    }
}
