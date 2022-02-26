package io.dowlath.demo.mockito.repository;

import io.dowlath.demo.mockito.model.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/***
 * Author : Dowlath Basha G
 * Date   : 2/26/2022
 * Time   : 3:20 PM
 ***/
public class UserRepository {
    private Map<String,User> users = new HashMap<String,User>();
    public UserRepository(){

        // adminUsers
        users.put("dowlath",User.createAdminUser("dowlath","letmein"));


        // regularUsers
        users.put("arsh",User.createRegularUser("arsh","startme"));
        users.put("ariz",User.createRegularUser("ariz","myPassword"));
        users.put("suzie",User.createRegularUser("suzie","myway"));

    }
    public User findByUserName(String userName) {
        return users.get(userName);
    }

    public List<User> findAll(){
        return new LinkedList<>(users.values());
    }
}
