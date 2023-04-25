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

public class REPLYCommand extends ICommand{
    private PostService postService;
    public REPLYCommand(){
        postService=PostService.getInstance();
    }

    @Override
    public void execute(String[] command) throws BadCommandException, UserAlreadyExistsException, InvalidUserException, InvalidPostException {
        if(command.length<3)
            throw new BadCommandException("Incorrect params for REPLY command, enter post id an text");
        Post originalPost=postService.getPost(Integer.valueOf(command[1]));
        if(originalPost==null)
            throw  new InvalidPostException("No post exists with given id");

        String text= PostHelper.getText(command,2);
        Post post=new Post(text);
        postService.savePost(post);
        originalPost.addComment(post);
    }


}
