package com.s28572.books.Controllers;

import com.s28572.books.Services.PublisherService;
import org.springframework.stereotype.Controller;

@Controller
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    public void showPublishers() {
        publisherService.printPublishers(publisherService.showPublishers());
    }

    public void addPublisher() {
        publisherService.addPublisher();
    }
}
