package org.ecommerce.service;

import org.ecommerce.data.model.User;
import org.ecommerce.dtos.request.LoginRequest;
import org.ecommerce.dtos.request.LogoutRequest;
import org.ecommerce.dtos.request.RegisterRequest;

public interface UserService {
    User register(RegisterRequest registerRequest);
    void login(LoginRequest loginRequest);
    void logout(LogoutRequest logoutRequest);
    User findUser(String fullName);
}
