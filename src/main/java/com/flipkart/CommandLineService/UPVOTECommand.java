package com.flipkart.CommandLineService;

import com.flipkart.Exceptions.BadCommandException;
import com.flipkart.Exceptions.InvalidPostException;
import com.flipkart.PostService.Post;
import com.flipkart.PostService.PostService;
import com.flipkart.UserService.UserService;

public class UPVOTECommand extends ICommand{
    private PostService postService;
    private UserService userService;

    public UPVOTECommand(){
        this.postService=PostService.getInstance();
        this.userService=UserService.getInstance();
    }
    @Override
    public void execute(String[] command) throws BadCommandException, InvalidPostException {
        Post post=postService.getPost(Integer.valueOf(command[1]));
        post.addUpVote(userService.getActiveUser());
    }
}
