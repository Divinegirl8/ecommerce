package org.ecommerce.dtos.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String fullName;
    private String password;

}
