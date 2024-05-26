package com.dlwlrtjdrhd.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service //beam
public class AuthenticationService {

    public boolean authenticate(String username, String password){

        boolean isValidUserName = username.equalsIgnoreCase("mmjj");
        boolean isValiedPassword = password.equalsIgnoreCase("mj");

        return isValidUserName && isValiedPassword;
    }

}
