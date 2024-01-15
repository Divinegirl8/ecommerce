package org.ecommerce.data.repository;

import org.ecommerce.data.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,String> {
    Product findByProductId(String productId);
    List<Product> findByProductIdIs(String productId);
}
