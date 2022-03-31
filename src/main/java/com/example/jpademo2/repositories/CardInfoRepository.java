package com.example.jpademo2.repositories;

import com.example.jpademo2.models.CardInfo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called CardInfoRepository
// CRUD refers Create, Read, Update, Delete

public interface CardInfoRepository extends CrudRepository<CardInfo, Integer> {

}
