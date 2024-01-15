package org.ecommerce.service.Implementation;

import org.ecommerce.data.model.Address;
import org.ecommerce.data.repository.UserRepository;
import org.ecommerce.dtos.request.LoginRequest;
import org.ecommerce.dtos.request.RegisterRequest;
import org.ecommerce.exception.InvalidCredentials;
import org.ecommerce.exception.UserExistException;
import org.ecommerce.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplementationTest {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @AfterEach
    void cleanUp(){
        userRepository.deleteAll();
    }



    @Test void register_User_Count_Is_One(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("firstname");
        registerRequest.setLastName("lastname");
        registerRequest.setPassword("password");
        registerRequest.setPhoneNumber("0801400");
        registerRequest.setEmailAddress("iam@Email");

        Address address = new Address();
        address.setCityName("yaba");
        address.setStreet("3 Tunde street");
        address.setState("Lagos");
        address.setCountryName("Nigeria");
        address.setHouseNumber("9");
        registerRequest.setHomeAddress(address);
        userService.register(registerRequest);
        assertEquals(1,userRepository.count());
    }
    @Test void register_UserWith_Same_Name_Throws_Exception(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("firstname");
        registerRequest.setLastName("lastname");
        registerRequest.setPassword("password");
        registerRequest.setPhoneNumber("0801400");
        registerRequest.setEmailAddress("iam@Email");

        Address address = new Address();
        address.setCityName("yaba");
        address.setStreet("3 Tunde street");
        address.setState("Lagos");
        address.setCountryName("Nigeria");
        address.setHouseNumber("9");
        registerRequest.setHomeAddress(address);
        userService.register(registerRequest);
        assertThrows(UserExistException.class,()-> userService.register(registerRequest));
    }

    @Test void register_User_Login(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("firstname");
        registerRequest.setLastName("lastname");
        registerRequest.setPassword("password");
        registerRequest.setPhoneNumber("0801400");
        registerRequest.setEmailAddress("iam@Email");


        Address address = new Address();
        address.setCityName("yaba");
        address.setStreet("3 Tunde street");
        address.setState("Lagos");
        address.setCountryName("Nigeria");
        address.setHouseNumber("9");
        registerRequest.setHomeAddress(address);
        userService.register(registerRequest);
        assertFalse(userService.findUser("firstname lastname").isLogin());

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setFullName("firstname lastname");
        loginRequest.setPassword("password");
        userService.login(loginRequest);
        assertTrue(userService.findUser("firstname lastname").isLogin());
    }

    @Test void register_User_Login_WIth_Wrong_Username_Throws_Error(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("firstname");
        registerRequest.setLastName("lastname");
        registerRequest.setPassword("password");
        registerRequest.setPhoneNumber("0801400");
        registerRequest.setEmailAddress("iam@Email");


        Address address = new Address();
        address.setCityName("yaba");
        address.setStreet("3 Tunde street");
        address.setState("Lagos");
        address.setCountryName("Nigeria");
        address.setHouseNumber("9");
        registerRequest.setHomeAddress(address);
        userService.register(registerRequest);
        assertFalse(userService.findUser("firstname lastname").isLogin());

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setFullName("fullName");
        loginRequest.setPassword("password");
        assertThrows(InvalidCredentials.class,()->userService.login(loginRequest));
    }

    @Test void register_User_Login_WIth_Wrong_Password_Throws_Error(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("firstname");
        registerRequest.setLastName("lastname");
        registerRequest.setPassword("password");
        registerRequest.setPhoneNumber("0801400");
        registerRequest.setEmailAddress("iam@Email");


        Address address = new Address();
        address.setCityName("yaba");
        address.setStreet("3 Tunde street");
        address.setState("Lagos");
        address.setCountryName("Nigeria");
        address.setHouseNumber("9");
        registerRequest.setHomeAddress(address);
        userService.register(registerRequest);
        assertFalse(userService.findUser("firstname lastname").isLogin());

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setFullName("firstname lastname");
        loginRequest.setPassword("word");
        assertThrows(InvalidCredentials.class,()->userService.login(loginRequest));
    }

}