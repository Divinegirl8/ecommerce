package org.ecommerce.exception;

public class ProductDoesNotExist extends RuntimeException {
    public ProductDoesNotExist(String message) {
        super(message);
    }
}
