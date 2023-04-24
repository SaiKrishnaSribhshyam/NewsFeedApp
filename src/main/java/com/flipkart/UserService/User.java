package com.flipkart.UserService;

import com.flipkart.PostService.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String userName;
    private List<User> followees;
    private List<Post> posts;

    public List<User> getFollowees() {
        return followees;
    }

    public List<Post> getPosts() {
        return posts;
    }

    private User(UserBuilder userBuilder){
        this.userName= userBuilder.userName;
        followees=new ArrayList<User>();
        posts=new ArrayList<Post>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

    public static class UserBuilder{
        private String userName;
        public UserBuilder setUserName(String userName){
            this.userName=userName;
            return this;
        }

        public User buildUser(){
            return new User(this);
        }
    }
}
