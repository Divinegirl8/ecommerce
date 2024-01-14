package org.ecommerce.data.repository;

import org.ecommerce.data.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
