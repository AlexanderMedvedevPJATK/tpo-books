package com.s28572.books.Repositories;

import com.s28572.books.Entities.Author;
import com.s28572.books.Entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    List<Publisher> findByNameContainingIgnoreCase(String name);
}
