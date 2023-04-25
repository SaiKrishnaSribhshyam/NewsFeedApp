package com.flipkart.CommandLineService;

import com.flipkart.Exceptions.BadCommandException;
import com.flipkart.Exceptions.InvalidUserException;
import com.flipkart.UserService.User;
import com.flipkart.UserService.UserService;

public class FOLLOWCommand extends ICommand{
    private UserService userService;

    public FOLLOWCommand(){
        this.userService=UserService.getInstance();
    }
    @Override
    public void execute(String[] command) throws BadCommandException, InvalidUserException {
        if(!userService.isUserExists(command[1])){
            throw new InvalidUserException("User with given name not exists");
        }
        User followee= userService.getUser(command[1]);
        userService.addFollowee(followee);
    }
}
