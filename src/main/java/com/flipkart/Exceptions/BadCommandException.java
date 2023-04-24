package com.flipkart.Exceptions;

public class BadCommandException extends Exception{
    public BadCommandException(String message){
        super(message);
    }
}
