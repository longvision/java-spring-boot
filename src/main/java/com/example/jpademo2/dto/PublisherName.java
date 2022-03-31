package com.example.jpademo2.dto;

// import lombok.Getter;
// import lombok.RequiredArgsConstructor;
// import lombok.Setter;

// @Getter
// @Setter
// @RequiredArgsConstructor
public class PublisherName {
    private Integer publisherId;
    private String publisherName;
    
    public Integer getPublisherId() {
        return publisherId;
    }
    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }
    public String getPublisherName() {
        return publisherName;
    }
    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    
}



/*
https://javatodev.com/lombok-spring-boot/

*/