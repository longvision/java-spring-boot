package com.example.jpademo2.controllers;

import java.util.List;

import com.example.jpademo2.dto.MessageDetails;
import com.example.jpademo2.dto.PublisherName;
import com.example.jpademo2.models.Publisher;
import com.example.jpademo2.repositories.PublisherRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {
    
    private final PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @GetMapping("/publishers")
    public Iterable<Publisher> getPublishers() {
        return publisherRepository.findAll();
    }

    @PostMapping("/publishers")
    public ResponseEntity<MessageDetails> addPublisher(@RequestBody Publisher publisher) {
        publisherRepository.save(publisher);
        MessageDetails msg = new MessageDetails("The new publisher was inserted successfully.");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(msg);
    }

    @PutMapping("/publishers")
    public ResponseEntity<MessageDetails> updatePublisher(@RequestBody Publisher publisher) {
        Publisher publisher2 = publisherRepository.findById(publisher.getPublisherId()).get();
        publisher2.setPublisherName(publisher.getPublisherName());
        publisherRepository.save(publisher2);
        MessageDetails msg = new MessageDetails("The new publisher was updated successfully.");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(msg);
    }

    @GetMapping("/publishers/names")
    public List<PublisherName> gPublisherNames() {
        return publisherRepository.findPublisherList();
    }
}


//curl -i -X POST localhost:8080/publishers -H 'Content-type:application/json' -d '{"publisherName":"PWS"}'
//curl -i -X POST localhost:8080/publishers -H 'Content-type:application/json' -d '{"publisherName":"MSFT"}'
//curl -i -X POST localhost:8080/publishers -H 'Content-type:application/json' -d '{"publisherName":"SAMS"}'