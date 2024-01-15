package org.ecommerce.service.Implementation;

import org.ecommerce.data.model.Product;
import org.ecommerce.data.model.ProductCategory;
import org.ecommerce.data.repository.ProductRepository;
import org.ecommerce.dtos.request.AddProductRequest;
import org.ecommerce.dtos.request.EditProductRequest;
import org.ecommerce.exception.ProductDoesNotExist;
import org.ecommerce.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.ecommerce.utils.Mappers.Map.setProduct;

@Service
public class VendorServiceImplementation implements VendorService {
    @Autowired
    ProductRepository productRepository;


    @Override
    public Product addProduct(AddProductRequest addProductRequest) {
        Product product = setProduct("PID"+(productRepository.count()+1), addProductRequest.getProductName(), addProductRequest.getPrice(), addProductRequest.getProductDescription(), addProductRequest.getProductCategory());
        productRepository.save(product);
        return product;
    }

    @Override
    public void removeProduct(String productId) {
        Product product = productRepository.findByProductId(productId);

        if (product == null) throw new ProductDoesNotExist("product not found");

        productRepository.delete(product);
    }

    @Override
    public Product editProduct(EditProductRequest editProductRequest) {
        Product product = productRepository.findByProductId(editProductRequest.getProductId());

        if (product == null) throw new ProductDoesNotExist("product not found");

        if (editProductRequest.isReplaceExisting()) {
            product.setProductName(editProductRequest.getProductName());
            if (editProductRequest.getPrice() >= 0) {
                product.setPrice(editProductRequest.getPrice());
            }else throw new PriceMustBeGreaterThanAndEqualsToZero("price must be greater or equals to zero");
            product.setProductDescription(editProductRequest.getProductDescription());
            product.setProductCategory(editProductRequest.getProductCategory());
        } else {

            if (editProductRequest.getProductName() != null) {
                product.setProductName(editProductRequest.getProductName());
            }
            if (editProductRequest.getPrice() >= 0) {
                product.setPrice(editProductRequest.getPrice());
            } else throw new PriceMustBeGreaterThanAndEqualsToZero("price must be greater or equals to zero");
            if (editProductRequest.getProductDescription() != null) {
                product.setProductDescription(editProductRequest.getProductDescription());
            }
            if (editProductRequest.getProductCategory() != null) {
                product.setProductCategory(editProductRequest.getProductCategory());
            }
        }
        productRepository.save(product);
        return product;
    }


}
