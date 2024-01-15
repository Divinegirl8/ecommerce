package org.ecommerce.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {
    @Id
    private String userId;
    private String emailAddress;
    private Address homeAddress;
    private String fullName;
    private String password;
    private String phoneNumber;
    private boolean login;
}
