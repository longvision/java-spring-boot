package com.example.jpademo2.dto;

public class MessageDetails {
    private String message;

    public MessageDetails(String message) {
        this.message = message;
    }

    public MessageDetails() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
