package io.dowlath.demo.mockito.service;

import io.dowlath.demo.mockito.model.User;
import io.dowlath.demo.mockito.repository.UserRepository;

import java.util.Set;
import java.util.stream.Collectors;

/***
 * Author : Dowlath Basha G
 * Date   : 2/26/2022
 * Time   : 3:19 PM
 ***/
public class AuthenticationService {
    private UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public boolean authenticate(String userName,String password){
        User user = userRepository.findByUserName(userName);
        return user.getPassword().equals(password);
    }

   /* public Set<User> getRegularUsers(){
        return userRepository.findAll()
                .stream()
                .filter(user -> user.isLive() && user.getUserType() == User.UserType.REGULAR_USER)
                .collect(Collectors.toSet());
    }
    public Set<User> getAdminUsers(){
        return userRepository.findAll()
                .stream()
                .filter(user -> user.isLive() && user.getUserType() == User.UserType.ADMIN_USER)
                .collect(Collectors.toSet());
    }*/
    // refactored
   public Set<User> getRegularUsers(){
       return getUsersByUserType(User.UserType.REGULAR_USER);
   }
    public Set<User> getAdminUsers(){
        return getUsersByUserType(User.UserType.ADMIN_USER);
    }

    public Set<User> getUsersByUserType(User.UserType userType){
        return userRepository.findAll()
                .stream()
                .filter(user -> user.isLive() && user.getUserType() == User.UserType.ADMIN_USER)
                .collect(Collectors.toSet());
    }

}
