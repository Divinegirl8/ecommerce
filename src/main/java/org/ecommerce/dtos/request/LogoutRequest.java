package org.ecommerce.dtos.request;

import lombok.Data;

@Data
public class LogoutRequest {
    private String fullName;
    private String password;
}
