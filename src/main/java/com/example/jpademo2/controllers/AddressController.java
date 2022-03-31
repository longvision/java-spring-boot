package com.example.jpademo2.controllers;

import java.util.List;

import com.example.jpademo2.dto.MessageDetails;
import com.example.jpademo2.dto.CustomerName;
import com.example.jpademo2.models.Address;
import com.example.jpademo2.repositories.AddressRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    private final AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping("/address")
    public Iterable<Address> getAddresss() {
        return addressRepository.findAll();
    }

    @PostMapping("/address")
    public ResponseEntity<MessageDetails> addAddress(@RequestBody Address address) {
        addressRepository.save(address);
        MessageDetails msg = new MessageDetails("The new address was inserted successfully.");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(msg);
    }

    // @PutMapping("/address")
    // public ResponseEntity<MessageDetails> updateAddress(@RequestBody Address
    // address) {
    // Address address = addressRepository.findById(address.getAddressId()).get();
    // address2.setAddressName(address.getAddressName());
    // addressRepository.save(address2);
    // MessageDetails msg = new MessageDetails("The new address was updated
    // successfully.");
    // return ResponseEntity.status(HttpStatus.ACCEPTED).body(msg);
    // }

}

// curl -i -X POST localhost:8080/address -H 'Content-type:application/json'
// -d '{"addressName":"PWS"}'
// curl -i -X POST localhost:8080/addresss -H 'Content-type:application/json'
// -d '{"addressName":"MSFT"}'
// curl -i -X POST localhost:8080/addresss -H 'Content-type:application/json'
// -d '{"addressName":"SAMS"}'