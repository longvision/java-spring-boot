package com.example.jpademo2.models;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.print.attribute.standard.DateTimeAtCompleted;

import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer orderId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    Customer customer;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "orderItemId")
    Set<OrderItem> orderItems;

    public Order(Integer orderId, Customer customer, Set<OrderItem> orderItems) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderItems = orderItems;
    }

    public Order() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

}
