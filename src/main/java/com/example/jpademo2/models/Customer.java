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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.print.attribute.standard.DateTimeAtCompleted;

import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer customerId;
    String customerName;
    String telephoneNo;
    String emailAddress;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    Address shippingAddress;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    Address billingAddress;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    CardInfo cardInfo;

    public Customer(Integer customerId, String customerName, String telephoneNo, String emailAddress,
            Address shippingAddress, Address billingAddress, CardInfo cardInfo) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.telephoneNo = telephoneNo;
        this.emailAddress = emailAddress;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.cardInfo = cardInfo;
    }

    public Customer() {
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public CardInfo getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
    }

}
