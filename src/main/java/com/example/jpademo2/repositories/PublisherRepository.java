package com.example.jpademo2.repositories;

import com.example.jpademo2.models.Publisher;

import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Integer>, CustomizedPublisherRepository {
    
}
