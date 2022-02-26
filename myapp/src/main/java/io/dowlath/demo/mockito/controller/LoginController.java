package io.dowlath.demo.mockito.controller;

import io.dowlath.demo.mockito.service.AuthenticationService;

/***
 * Author : Dowlath Basha G
 * Date   : 2/26/2022
 * Time   : 3:19 PM
 ***/
public class LoginController {
    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    public String service(String userName,String password){
        return authenticationService.authenticate(userName,password) ? "/home" : "/login";
    }
}
