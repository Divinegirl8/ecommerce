package org.ecommerce.data.model;

import lombok.Data;

@Data
public class BillingInformation {
    private int receiverPhoneNumber;
    private String receiverName;
    private  Address deliveryAddress;
    private CreditCardInformation creditCard;
}
