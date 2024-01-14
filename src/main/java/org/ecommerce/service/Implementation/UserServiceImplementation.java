package org.ecommerce.service.Implementation;

import org.ecommerce.data.model.User;
import org.ecommerce.data.repository.UserRepository;
import org.ecommerce.dtos.request.LoginRequest;
import org.ecommerce.dtos.request.RegisterRequest;
import org.ecommerce.exception.UserExistException;
import org.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.ecommerce.utils.Mappers.Map.map;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User register(RegisterRequest registerRequest) {
        if (userExist(registerRequest.getFirstName(),registerRequest.getLastName())) throw new UserExistException(registerRequest.getFirstName() + " " + registerRequest.getLastName() + " already exist");
        User user = map("UID"+(userRepository.count()+1),registerRequest.getFirstName(),registerRequest.getLastName(),registerRequest.getPassword(),registerRequest.getPhoneNumber(),registerRequest.getEmailAddress(),registerRequest.getHomeAddress());
        userRepository.save(user);
        return user;
    }

    @Override
    public void login(LoginRequest loginRequest) {

    }

    private boolean userExist(String firstName, String lastName){
        User user = userRepository.findUserByFullName(firstName + " " + lastName);
        return user != null;
    }
}
