package com.flipkart.CommandLineService;

import com.flipkart.Exceptions.BadCommandException;
import com.flipkart.Exceptions.InvalidPostException;
import com.flipkart.Exceptions.InvalidUserException;
import com.flipkart.Exceptions.UserAlreadyExistsException;
import com.flipkart.PostService.Post;
import com.flipkart.PostService.PostService;
import com.flipkart.UserService.User;
import com.flipkart.UserService.UserService;
import com.flipkart.Utils.PostHelper;

public class POSTCommand extends ICommand{
    private UserService userService;
    private PostService postService;
    public POSTCommand(){
        userService=UserService.getInstance();
        postService=PostService.getInstance();
    }

    @Override
    public void execute(String[] command) throws BadCommandException, UserAlreadyExistsException, InvalidUserException, InvalidPostException {
        String text= PostHelper.getText(command,1);
        User loggedInUser=userService.getActiveUser();
        Post post=new Post(text);
        post.setUser(userService.getActiveUser());
        postService.savePost(post);
        userService.addPost(post);
    }

}
