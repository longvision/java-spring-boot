package com.example.jpademo2.models;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.print.attribute.standard.DateTimeAtCompleted;

import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "orderItem")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer orderItemId;
    int quantity;

    @OneToOne(targetEntity = Book.class, fetch = FetchType.EAGER)
    Book book;

    public OrderItem(Integer orderItemId, Book book, int quantity) {
        this.orderItemId = orderItemId;
        this.book = book;
        this.quantity = quantity;
    }

    public OrderItem() {
    }

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
