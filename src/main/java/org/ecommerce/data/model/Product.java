package org.ecommerce.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Product {
    @Id
    private String productId;
    private String productName;
    private int price;
    private String productDescription;
    private  ProductCategory productCategory;
}
