package org.ecommerce.exception;

public class InvalidCredentials extends RuntimeException{
    public InvalidCredentials(){
        super("Credentials is invalid");
    }
}
