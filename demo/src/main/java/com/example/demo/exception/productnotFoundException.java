package com.example.demo.exception;

public class productnotFoundException extends IllegalArgumentException {
    public productnotFoundException(String mess) {
        super(mess);
    }
}
