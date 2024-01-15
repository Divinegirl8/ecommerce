package org.ecommerce.data.model;

import lombok.Data;

@Data
public class BillingInformation {
    private String receiverPhoneNumber;
    private String receiverName;
    private  Address deliveryAddress;
    private CreditCardInformation creditCard;
}
