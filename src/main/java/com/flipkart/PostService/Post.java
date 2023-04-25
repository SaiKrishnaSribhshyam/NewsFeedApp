package com.flipkart.PostService;

import com.flipkart.UserService.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
    private int id;
    private String text;
    private List<Post> comments;
    private final LocalDateTime timeStamp;
    private List<User> upvotes;
    private List<User> downvotes;

    public Post(String text){
        this.text=text;
        this.timeStamp=LocalDateTime.now();
        comments=new ArrayList<Post>();
        upvotes=new ArrayList<User>();
        downvotes=new ArrayList<User>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Post> getComments() {
        return comments;
    }

    public void addComment(Post comment){
        comments.add(comment);
    }

    public List<User> getUpvotes() {
        return upvotes;
    }

    public List<User> getDownvotes() {
        return downvotes;
    }

    public void addUpVote(User user){
        this.upvotes.add(user);
    }

    public void addDownVote(User user){
        this.downvotes.add(user);
    }
}
