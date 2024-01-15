package org.ecommerce.service.Implementation;

public class PriceMustBeGreaterThanAndEqualsToZero extends RuntimeException {
    public PriceMustBeGreaterThanAndEqualsToZero(String message) {
        super(message);
    }
}
