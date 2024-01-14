package org.ecommerce.data.model;

import lombok.Data;

@Data
public class Customers {
    private BillingInformation billingInformation;
    private  ShoppingCart[] shoppingCart;
}
