package com.example.bookmyshow1.exception;

public class ShowSeatNotAvailableException extends Throwable {
    public ShowSeatNotAvailableException(Long id) {
        super("Show seat with id " +id + "is not available");
    }
}
