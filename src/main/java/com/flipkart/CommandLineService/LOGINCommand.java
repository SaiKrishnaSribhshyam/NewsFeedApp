package com.flipkart.CommandLineService;

import com.flipkart.Exceptions.BadCommandException;
import com.flipkart.Exceptions.InvalidPostException;
import com.flipkart.Exceptions.InvalidUserException;
import com.flipkart.Exceptions.UserAlreadyExistsException;
import com.flipkart.UserService.UserService;

public class LOGINCommand extends ICommand{
    private UserService userService;

    public LOGINCommand(){
        this.userService=UserService.getInstance();
    }
    @Override
    public void execute(String[] command) throws BadCommandException, InvalidUserException {
        if(!userService.isUserExists(command[1])){
            throw new InvalidUserException("User with given name not exists");
        }
        userService.setActiveUser(command[1]);
    }
}
