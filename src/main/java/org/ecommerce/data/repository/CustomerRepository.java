package org.ecommerce.data.repository;

import org.ecommerce.data.model.Customers;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customers,String> {
}
