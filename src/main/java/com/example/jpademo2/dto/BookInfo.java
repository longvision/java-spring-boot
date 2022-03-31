package com.example.jpademo2.dto;

import java.math.BigDecimal;

public class BookInfo {
    private Integer id;
    private String isbn;
	private String title;
	private BigDecimal price;
	private boolean available;
    private Integer publisherId;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public Integer getPublisherId() {
        return publisherId;
    }
    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    
}
