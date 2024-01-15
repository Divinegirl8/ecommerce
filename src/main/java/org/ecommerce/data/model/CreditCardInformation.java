package org.ecommerce.data.model;

import lombok.Data;

@Data
public class CreditCardInformation {
    private String cardCvv;
    private  String cardExpirationYear;
    private String cardExpirationMonth;
    private String creditCardNumber;
    private String nameOnCard;
    private  CardType cardType;
}
