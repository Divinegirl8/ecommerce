package org.ecommerce.service.Implementation;

import org.ecommerce.data.model.*;
import org.ecommerce.data.repository.CustomerRepository;
import org.ecommerce.service.CustomerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceImplementationTest {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepository customerRepository;

    @AfterEach
    void cleanUp(){
        customerRepository.deleteAll();
    }

    @Test void shop(){
        BillingInformation billingInformation = new BillingInformation();
        billingInformation.setReceiverName("receiverName");

        Address address = new Address();
        address.setCityName("yaba");
        address.setStreet("3 Tunde street");
        address.setState("Lagos");
        address.setCountryName("Nigeria");
        address.setHouseNumber("9");
        billingInformation.setDeliveryAddress(address);

        billingInformation.setReceiverPhoneNumber("12345");

        CreditCardInformation creditCardInformation = new CreditCardInformation();
        creditCardInformation.setCardCvv("112");
        creditCardInformation.setCardType(CardType.MASTERCARD);
        creditCardInformation.setCreditCardNumber("534567890");
        creditCardInformation.setCardExpirationYear("1111");
        creditCardInformation.setCardExpirationMonth("12");
        creditCardInformation.setNameOnCard("name");
        billingInformation.setCreditCard(creditCardInformation);


    }

}