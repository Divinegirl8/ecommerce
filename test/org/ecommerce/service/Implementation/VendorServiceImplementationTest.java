package org.ecommerce.service.Implementation;

import org.ecommerce.data.repository.ProductRepository;
import org.ecommerce.service.VendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VendorServiceImplementationTest {
    @Autowired
    VendorService vendorService;
    @Autowired
    ProductRepository productRepository;

    @AfterEach
    void  cleanUp(){
        productRepository.deleteAll();;
    }

    @Test void addProduct_EditProduct(){
        vendorServic
    }

}