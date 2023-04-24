package com.flipkart.CommandLineService;

import com.flipkart.Exceptions.UserAlreadyExistsException;
import com.flipkart.UserService.User;
import com.flipkart.UserService.UserService;

public class SIGNUPCommand extends ICommand{
    private UserService userService;

    public SIGNUPCommand(){
        this.userService=UserService.getInstance();
    }
    @Override
    public void execute(String[] command) throws UserAlreadyExistsException {
        if(userService.isUserExists(command[1])){
            //throw exception
            throw new UserAlreadyExistsException("User with given UserName already present");
        }
        userService.addUser(command[1]);
    }
}
