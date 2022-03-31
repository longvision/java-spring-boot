package com.example.jpademo2.repositories;

import java.math.BigDecimal;

import com.example.jpademo2.models.Book;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called bookRepository
// CRUD refers Create, Read, Update, Delete

public interface BookRepository extends CrudRepository<Book, Integer>, CustomizedBookRepository {
    
    @Query(value="SELECT * FROM book WHERE price BETWEEN :from AND :to", nativeQuery = true)
    Iterable<Book> findByPriceRange(BigDecimal from, BigDecimal to);
}
