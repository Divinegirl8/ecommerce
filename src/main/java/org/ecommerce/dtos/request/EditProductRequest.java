package org.ecommerce.dtos.request;

import lombok.Data;
import org.ecommerce.data.model.ProductCategory;

@Data
public class EditProductRequest {
    String productId;
    String productName;
    int price;
    String productDescription;
    ProductCategory productCategory;
    boolean replaceExisting;
}
