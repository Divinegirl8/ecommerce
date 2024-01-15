package org.ecommerce.service;

import org.ecommerce.data.model.Product;
import org.ecommerce.data.model.ProductCategory;
import org.ecommerce.dtos.request.AddProductRequest;
import org.ecommerce.dtos.request.EditProductRequest;

import java.util.List;

public interface VendorService {
    Product addProduct(AddProductRequest addProductRequest);
    void removeProduct(String productId);

    Product  editProduct(EditProductRequest editProductRequest);
    void removeAllProduct();
    List<Product> viewAllProducts();
}
