package io.dowlath.demo.mockito.model;

import java.util.Objects;

/***
 * Author : Dowlath Basha G
 * Date   : 2/26/2022
 * Time   : 3:20 PM
 ***/
public class User {
    public enum UserType { REGULAR_USER, ADMIN_USER }
    private String userName;
    private String password;
    private boolean live = true;
    private final UserType userType;


    public User(String userName,String password,UserType userType){
        this.userName = userName;
        this.password = password;
        this.userType = userType;
    }

    public static User createAdminUser(String userName,String password){
        return new User(userName,password,UserType.ADMIN_USER);
    }

    public static User createRegularUser(String userName,String password){
        return new User(userName,password,UserType.REGULAR_USER);
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLive(){
        return live;
    }

    public UserType getUserType(){
        return userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return live == user.live && Objects.equals(userName, user.userName) && Objects.equals(password, user.password) && userType == user.userType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password, live, userType);
    }
}
