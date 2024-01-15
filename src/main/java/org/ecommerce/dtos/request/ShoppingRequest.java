package org.ecommerce.dtos.request;

import lombok.Data;
import org.ecommerce.data.model.BillingInformation;
import org.ecommerce.data.model.ShoppingCart;

@Data
public class ShoppingRequest {
    private BillingInformation billingInformation;
    private  ShoppingCart[] shoppingCart;
}
