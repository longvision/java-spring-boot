package com.example.jpademo2.repositories;

import java.math.BigDecimal;
import java.util.*;

import com.example.jpademo2.models.Address;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called AddressRepository
// CRUD refers Create, Read, Update, Delete

public interface AddressRepository extends CrudRepository<Address, Integer> {

    // List<Address> findAddressList();

}
