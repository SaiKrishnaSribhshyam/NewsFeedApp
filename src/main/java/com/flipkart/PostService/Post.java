package com.flipkart.PostService;

import com.flipkart.UserService.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post implements Comparable<Post> {
    private int id;
    private String text;
    private List<Post> comments;
    private final LocalDateTime timeStamp;
    private List<User> upvotes;
    private List<User> downvotes;
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public int getScore(){
        return this.upvotes.size()-this.downvotes.size();
    }

    @Override
    public int compareTo(Post otherPost){
        int thisPostScore=this.getScore();
        int otherPostScore=otherPost.getScore();
        if(thisPostScore==otherPostScore ){
            if(this.comments.size()==otherPost.comments.size())
                return otherPost.timeStamp.compareTo(this.timeStamp);
            return otherPost.comments.size()-this.comments.size();
        }
        return otherPostScore-thisPostScore;
    }
}
