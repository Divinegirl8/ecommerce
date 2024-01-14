package org.ecommerce.utils.Mappers;

import org.ecommerce.data.model.Address;
import org.ecommerce.data.model.User;

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
}
