package org.ecommerce.service;


import org.ecommerce.data.model.BillingInformation;
import org.ecommerce.data.model.Customers;
import org.ecommerce.dtos.request.ShoppingRequest;

public interface CustomerService {
    Customers shop(ShoppingRequest shoppingRequest);
}
