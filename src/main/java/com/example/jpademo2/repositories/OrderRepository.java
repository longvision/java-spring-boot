package com.example.jpademo2.repositories;

import java.math.BigDecimal;

import com.example.jpademo2.models.Order;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called OrderRepository
// CRUD refers Create, Read, Update, Delete

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
