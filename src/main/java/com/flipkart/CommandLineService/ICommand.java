package com.flipkart.CommandLineService;

import com.flipkart.Exceptions.BadCommandException;
import com.flipkart.Exceptions.InvalidPostException;
import com.flipkart.Exceptions.InvalidUserException;
import com.flipkart.Exceptions.UserAlreadyExistsException;


public abstract class ICommand {
    public abstract void execute(String[] command) throws BadCommandException, UserAlreadyExistsException, InvalidUserException, InvalidPostException;
}
