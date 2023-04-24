package com.flipkart.UserService;

import java.util.HashMap;
import java.util.HashSet;

public enum UserRepo {
    INSTANCE;
    private HashMap<String,User> users=new HashMap<>();

    public boolean isUserPresent(String userName){
        return users.containsKey(userName);
    }

    public void addUser(User newUser){
        if(!isUserPresent(newUser.getUserName()))
            users.put(newUser.getUserName(),newUser);
    }

    public User getUser(String userName){
        return users.get(userName);
    }
}
