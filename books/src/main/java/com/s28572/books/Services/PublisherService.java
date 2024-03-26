package com.s28572.books.Services;

import com.s28572.books.Entities.Publisher;
import com.s28572.books.Repositories.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public void save(Publisher publisher) {
        publisherRepository.save(publisher);
    }
}
