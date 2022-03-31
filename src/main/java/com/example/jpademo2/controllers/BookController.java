package com.example.jpademo2.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import com.example.jpademo2.dto.BookInfo;
import com.example.jpademo2.dto.MessageDetails;
import com.example.jpademo2.models.Book;
import com.example.jpademo2.models.Publisher;
import com.example.jpademo2.repositories.BookRepository;
import com.example.jpademo2.repositories.PublisherRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/books")
public class BookController {
    private static Logger logger = Logger.getLogger(BookController.class.getName());
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BookController(BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @GetMapping("/books")
    public List<BookInfo> getBooks() {
        List<BookInfo> books = bookRepository.findBookInfoList();
        return books;
    }

    @PostMapping("/books")
    public ResponseEntity<MessageDetails> addBook(@RequestBody BookInfo bookInfo) {
        Publisher publisher = publisherRepository.findById(bookInfo.getPublisherId()).get();
        Book book = new Book(bookInfo.getIsbn(), bookInfo.getTitle(), bookInfo.getPrice(), bookInfo.isAvailable(), publisher);
        bookRepository.save(book);
        publisher.getBooks().add(book);
        publisherRepository.save(publisher);
        MessageDetails msg = new MessageDetails("The new book was inserted successfully.");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(msg);
    }

    @PutMapping("/books")
    public ResponseEntity<MessageDetails> updateBook(@RequestBody BookInfo bookInfo) {
        BookInfo oldBookInfo = bookRepository.findBookInfoById(bookInfo.getId());

        // Check if the publisher id has been changed
        if (oldBookInfo.getPublisherId().equals(bookInfo.getPublisherId())) {
            // Since there is no publisher id change, just update the book information
            Publisher publisher = publisherRepository.findById(bookInfo.getPublisherId()).get();
            Book book = new Book(bookInfo.getIsbn(), bookInfo.getTitle(), bookInfo.getPrice(), bookInfo.isAvailable(), publisher);
            book.setId(bookInfo.getId());
            bookRepository.save(book);
        } else {
            // The publisher ID has been changed, now we need to find the old publisher
            Publisher oldPublisher = publisherRepository.findById(oldBookInfo.getPublisherId()).get();
            Book book = new Book(bookInfo.getIsbn(), bookInfo.getTitle(), bookInfo.getPrice(), bookInfo.isAvailable(), oldPublisher);
            book.setId(bookInfo.getId());

            // Remove that book from the old publisher
            oldPublisher.getBooks().remove(book);
            publisherRepository.save(oldPublisher);
            
            // Find the new publisher
            Publisher publisher = publisherRepository.findById(bookInfo.getPublisherId()).get();

            // Set that book with the new publisher
            book.setPublisher(publisher);
            bookRepository.save(book);

            // Add that book to the new publisher
            publisher.getBooks().add(book);
            publisherRepository.save(publisher);
        }
        
        MessageDetails msg = new MessageDetails("The book was updated successfully.");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(msg);
    }
    
    @DeleteMapping("/books/{id}")
    public ResponseEntity<MessageDetails> removeBook(@PathVariable Integer id) {
        BookInfo bookInfo = bookRepository.findBookInfoById(id);

        // Get the publisher object
        Publisher publisher = publisherRepository.findById(bookInfo.getPublisherId()).get();

        // Remove the book from the publisher
        Book book = new Book();
        book.setId(id);
        publisher.getBooks().remove(book);
        publisherRepository.save(publisher);

        // Remove the book from the database
        bookRepository.deleteById(id);
        MessageDetails msg = new MessageDetails("The book was removed successfully.");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(msg);
    }
    
    @PutMapping("/books/price")
    public ResponseEntity<MessageDetails> updateBookPrice(@RequestBody Book book) {
        logger.info("Update Book id = " + book.getId());
        logger.info("Update Book price = " + book.getPrice());
        Book book2 = bookRepository.findById(book.getId()).get();
        book2.setPrice(book.getPrice());
        bookRepository.save(book2);
        MessageDetails msg = new MessageDetails("The book price was updated successfully.");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(msg);
    }
    
    @GetMapping("/books/range/{from}/{to}")  
    public Iterable<Book> getBooksByRange(@PathVariable BigDecimal from, @PathVariable BigDecimal to) {
        return bookRepository.findByPriceRange(from, to);
    }

    @GetMapping("/books/test")
    public void test() {
        Publisher pub = new Publisher("AWS");
        this.publisherRepository.save(pub);

        Book b1 = new Book("111", "C++", new BigDecimal(56.78), true, pub);
        Book b2 = new Book("222", "Java", new BigDecimal(76.88), true, pub);

        pub.getBooks().add(b1);
        pub.getBooks().add(b2);

        this.publisherRepository.save(pub);
    }
    
}


//curl -i -X POST localhost:8080/books -H 'Content-type:application/json' -d '{"isbn":"7777", "title":"Database", "price":56.7, "available":true }'
//curl -i -X PUT localhost:8080/books -H 'Content-type:application/json' -d '{"id":1, "isbn":"7777", "title":"Database", "price":99.99, "available":true }'
//curl -i -X PUT localhost:8080/books/price -H 'Content-type:application/json' -d '{"id":1, "price":10.00 }'
//curl -i -X DELETE localhost:8080/books/1
//curl localhost:8080/books/range/50/100 
