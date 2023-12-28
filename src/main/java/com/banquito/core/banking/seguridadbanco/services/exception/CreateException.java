package com.banquito.core.banking.seguridadbanco.services.exception;

public class CreateException extends RuntimeException{
    public CreateException(String message){
        super(message);
    }
    public CreateException(String message, Exception cause){
        super(message, cause);
    }
}