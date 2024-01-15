package org.ecommerce.service.Implementation;

import org.ecommerce.data.model.ProductCategory;
import org.ecommerce.data.repository.ProductRepository;
import org.ecommerce.dtos.request.AddProductRequest;
import org.ecommerce.dtos.request.EditProductRequest;
import org.ecommerce.exception.ProductDoesNotExist;
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

    @Test void addProduct(){
        AddProductRequest addProductRequest = new AddProductRequest();
        addProductRequest.setProductName("Dress");
        addProductRequest.setProductDescription("lovely gown for adults");
        addProductRequest.setProductCategory(ProductCategory.CLOTHING);
        addProductRequest.setPrice(14500);
        vendorService.addProduct(addProductRequest);
        assertEquals(1,productRepository.count());
    }

    @Test void addProduct_With_Price_Less_Than_Zero(){
        AddProductRequest addProductRequest = new AddProductRequest();
        addProductRequest.setProductName("Dress");
        addProductRequest.setProductDescription("lovely gown for adults");
        addProductRequest.setProductCategory(ProductCategory.CLOTHING);
        addProductRequest.setPrice(-500);
        assertThrows(PriceMustBeGreaterThanAndEqualsToZero.class,()->vendorService.addProduct(addProductRequest));

    }
    @Test void  addProduct_EditProduct(){
        AddProductRequest addProductRequest = new AddProductRequest();
        addProductRequest.setProductName("Dress");
        addProductRequest.setProductDescription("lovely gown for adults");
        addProductRequest.setProductCategory(ProductCategory.CLOTHING);
        addProductRequest.setPrice(14500);
        vendorService.addProduct(addProductRequest);


        EditProductRequest editProductRequest = new EditProductRequest();
        editProductRequest.setProductId("PID1");
        editProductRequest.setProductName("necklace");
        editProductRequest.setProductCategory(ProductCategory.JEWELRY);
        editProductRequest.setProductDescription("beautiful necklace");
        editProductRequest.setPrice(230000);

        assertNotNull(vendorService.editProduct(editProductRequest));
    }

    @Test void addProduct_EditProduct_With_Wrong_UserName(){
        AddProductRequest addProductRequest = new AddProductRequest();
        addProductRequest.setProductName("Dress");
        addProductRequest.setProductDescription("lovely gown for adults");
        addProductRequest.setProductCategory(ProductCategory.CLOTHING);
        addProductRequest.setPrice(14500);
        vendorService.addProduct(addProductRequest);

        EditProductRequest editProductRequest = new EditProductRequest();
        editProductRequest.setProductId("PID10");
        editProductRequest.setProductName("necklace");
        editProductRequest.setProductCategory(ProductCategory.JEWELRY);
        editProductRequest.setProductDescription("beautiful necklace");
        editProductRequest.setPrice(230000);
        assertThrows(ProductDoesNotExist.class,()-> vendorService.editProduct(editProductRequest));
    }

    @Test void addProduct_EditProduct_With_Price_less_Than_0(){
        AddProductRequest addProductRequest = new AddProductRequest();
        addProductRequest.setProductName("Dress");
        addProductRequest.setProductDescription("lovely gown for adults");
        addProductRequest.setProductCategory(ProductCategory.CLOTHING);
        addProductRequest.setPrice(14500);
        vendorService.addProduct(addProductRequest);

        EditProductRequest editProductRequest = new EditProductRequest();
        editProductRequest.setProductId("PID1");
        editProductRequest.setProductName("necklace");
        editProductRequest.setProductCategory(ProductCategory.JEWELRY);
        editProductRequest.setProductDescription("beautiful necklace");
        editProductRequest.setPrice(-230000);
        assertThrows(PriceMustBeGreaterThanAndEqualsToZero.class,()-> vendorService.editProduct(editProductRequest));
    }

    @Test void addProduct_RemoveProduct(){
        AddProductRequest addProductRequest = new AddProductRequest();
        addProductRequest.setProductName("Dress");
        addProductRequest.setProductDescription("lovely gown for adults");
        addProductRequest.setProductCategory(ProductCategory.CLOTHING);
        addProductRequest.setPrice(14500);
        vendorService.addProduct(addProductRequest);
        assertEquals(1,productRepository.count());

        vendorService.removeProduct("PID1");
        assertEquals(0,productRepository.count());
    }

    @Test void addProduct_RemoveProduct_With_Wrong_Product_Id(){
        AddProductRequest addProductRequest = new AddProductRequest();
        addProductRequest.setProductName("Dress");
        addProductRequest.setProductDescription("lovely gown for adults");
        addProductRequest.setProductCategory(ProductCategory.CLOTHING);
        addProductRequest.setPrice(14500);
        vendorService.addProduct(addProductRequest);
        assertEquals(1,productRepository.count());

       assertThrows(ProductDoesNotExist.class,()->vendorService.removeProduct("PID"));

    }

    @Test void addProducts_RemoveAllProduct(){
        AddProductRequest addProductRequest = new AddProductRequest();
        addProductRequest.setProductName("Dress");
        addProductRequest.setProductDescription("lovely gown for adults");
        addProductRequest.setProductCategory(ProductCategory.CLOTHING);
        addProductRequest.setPrice(14500);
        vendorService.addProduct(addProductRequest);
        vendorService.addProduct(addProductRequest);
        vendorService.addProduct(addProductRequest);

        assertEquals(3,productRepository.count());

        vendorService.removeAllProduct();
        assertEquals(0,productRepository.count());

    }


}