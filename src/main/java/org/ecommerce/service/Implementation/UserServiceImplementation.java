package org.ecommerce.service.Implementation;

import org.ecommerce.data.model.User;
import org.ecommerce.data.repository.UserRepository;
import org.ecommerce.dtos.request.LoginRequest;
import org.ecommerce.dtos.request.LogoutRequest;
import org.ecommerce.dtos.request.RegisterRequest;
import org.ecommerce.exception.InvalidCredentials;
import org.ecommerce.exception.UserExistException;
import org.ecommerce.exception.UserNotFound;
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
    User user = userRepository.findUserByFullName(loginRequest.getFullName());

    if (!userExist(loginRequest.getFullName())) throw new InvalidCredentials();
    if (!user.getPassword().equals(loginRequest.getPassword())) throw new InvalidCredentials();
    user.setLogin(true);
    userRepository.save(user);
    }

    @Override
    public void logout(LogoutRequest logoutRequest) {
     User user = userRepository.findUserByFullName(logoutRequest.getFullName());

     if (!userExist(logoutRequest.getFullName())) throw new InvalidCredentials();
     if (!user.getPassword().equals(logoutRequest.getPassword())) throw new InvalidCredentials();
     user.setLogin(false);
     userRepository.save(user);
    }

    @Override
    public User findUser(String fullName) {
        User user = userRepository.findUserByFullName(fullName);

        if (user == null) throw new UserNotFound(fullName + " does not exist");
        return user;
    }

    private boolean userExist(String firstName, String lastName){
        User user = userRepository.findUserByFullName(firstName + " " + lastName);
        return user != null;
    }

    private boolean userExist(String name){
        User user = userRepository.findUserByFullName(name);
        return user != null;
    }
}
