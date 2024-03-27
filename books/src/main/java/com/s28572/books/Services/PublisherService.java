package com.s28572.books.Services;

import com.s28572.books.Entities.Publisher;
import com.s28572.books.Repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class PublisherService {
    private final PublisherRepository publisherRepository;
    private final Scanner scanner;

    public PublisherService(PublisherRepository publisherRepository, Scanner scanner) {
        this.publisherRepository = publisherRepository;
        this.scanner = scanner;
    }

    public Publisher getPublisher() {
        System.out.println("Would you like to add a publisher or find an existing one?");
        System.out.println("1. Add publisher");
        System.out.println("2. Find publisher");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            return addPublisher();
        } else if (choice == 2) {
            return choosePublisher(showPublishers());
        } else {
            System.out.println("Invalid choice");
        }

        return null;
    }

    public List<Publisher> showPublishers() {
        System.out.println("List all publishers or search?");
        System.out.println("1. List all publishers");
        System.out.println("2. Search for a publisher");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            return (List<Publisher>) publisherRepository.findAll();
        } else if (choice == 2) {
            return searchPublishers();
        } else {
            System.out.println("Invalid choice");
        }

        return null;
    }

    private List<Publisher> searchPublishers() {
        System.out.println("Enter publisher's name:");
        String name = scanner.nextLine();
        return publisherRepository.findByNameContainingIgnoreCase(name);
    }

    public Publisher choosePublisher(List<Publisher> publishers) {
        if (publishers == null || publishers.isEmpty()) {
            System.out.println("No publishers found");
            return null;
        }

        printPublishers(publishers);

        System.out.println("Choose publisher:");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice < 1 || choice > publishers.size()) {
            System.out.println("Invalid publisher choice");
            return null;
        }
        return publishers.get(choice - 1);
    }

    public void printPublishers(List<Publisher> publishers) {
        for (int i = 0; i < publishers.size(); i++) {
            System.out.println((i + 1) + ". " + publishers.get(i));
        }
    }

    public Publisher addPublisher() {
        System.out.println("Enter publisher's name:");
        String name = scanner.nextLine();

        Publisher publisher = new Publisher(name);
        publisherRepository.save(publisher);

        return publisher;
    }
}
