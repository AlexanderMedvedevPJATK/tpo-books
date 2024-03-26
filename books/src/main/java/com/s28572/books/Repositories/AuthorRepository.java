package com.s28572.books.Repositories;

import com.s28572.books.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByFirstName(String firstName);

    List<Author> findByLastName(String lastName);
}
