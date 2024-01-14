package org.ecommerce.dtos.request;

import lombok.Data;
import org.ecommerce.data.model.Address;

@Data
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String emailAddress;
    private Address homeAddress;

}
