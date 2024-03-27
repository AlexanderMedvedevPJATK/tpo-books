package com.s28572.books.Repositories;

import com.s28572.books.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    List<Author> findByFirstNameContainingIgnoreCase(String firstName);

    List<Author> findByLastNameContainingIgnoreCase(String lastName);
}
