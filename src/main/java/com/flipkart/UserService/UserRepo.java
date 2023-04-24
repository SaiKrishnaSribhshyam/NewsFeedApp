package com.flipkart.UserService;

import java.util.HashSet;

public enum UserRepo {
    INSTANCE;
    private HashSet<User> users=new HashSet<>();

    public boolean isUserPresent(User newUser){
        return users.contains(newUser);
    }

    public void addUser(User newUser){
        if(!isUserPresent(newUser))
            users.add(newUser);
    }
}
