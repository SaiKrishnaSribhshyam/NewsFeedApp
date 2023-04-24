package com.flipkart.CommandLineService;

import com.flipkart.Exceptions.BadCommandException;

import java.util.HashMap;

public class CommandExecutorFactory {
    private HashMap<NewsFeedCommand,ICommand> commandFactory;

    public CommandExecutorFactory(){
        commandFactory=new HashMap<>();
        commandFactory.put(NewsFeedCommand.SIGNUP,new SIGNUPCommand());
        commandFactory.put(NewsFeedCommand.LOGIN,new LOGINCommand());
    }

    public ICommand getCommandExecutor(NewsFeedCommand newsFeedCommand) throws BadCommandException {
        if(!commandFactory.containsKey(newsFeedCommand)){
            throw new BadCommandException("No Command exists with the entered text");
        }
        return commandFactory.get(newsFeedCommand);
    }
}
