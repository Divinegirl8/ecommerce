package org.ecommerce.data.repository;

import org.ecommerce.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    User findUserByFullName(String name);
}
