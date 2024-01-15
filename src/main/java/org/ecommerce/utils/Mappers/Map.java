package org.ecommerce.utils.Mappers;

import org.ecommerce.data.model.Address;
import org.ecommerce.data.model.Product;
import org.ecommerce.data.model.ProductCategory;
import org.ecommerce.data.model.User;
import org.ecommerce.service.Implementation.PriceMustBeGreaterThanAndEqualsToZero;

public class Map {
    public static User map(String userId, String firstName, String lastName, String password, String phoneNumber, String emailAddress, Address homeAddress) {
        User user = new User();
        user.setUserId(userId);
       user.setFullName(firstName + " " + lastName);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setEmailAddress(emailAddress);
        user.setHomeAddress(homeAddress);
        return user;
    }

    public static Product setProduct(String productId, String productName, int price, String productDescription, ProductCategory productCategory){
        Product product = new Product();

        product.setProductId(productId);
        product.setProductName(productName);
        if (price >= 0){
        product.setPrice(price);}else throw new PriceMustBeGreaterThanAndEqualsToZero("price must not be less than 0");
        product.setProductDescription(productDescription);
        product.setProductCategory(productCategory);
       return product;
    }
}
