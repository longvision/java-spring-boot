package com.example.jpademo2.dto;

// import lombok.Getter;
// import lombok.RequiredArgsConstructor;
// import lombok.Setter;

// @Getter
// @Setter
// @RequiredArgsConstructor
public class CustomerName {
    private Integer customerId;
    private String customerName;

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

}

/*
 * https://javatodev.com/lombok-spring-boot/
 * 
 */