package com.abhi.modelmapper.exception;

public class CustomerIdNotFoundException extends RuntimeException {
    public CustomerIdNotFoundException(String msg ) {
     super(msg);
    }
}
