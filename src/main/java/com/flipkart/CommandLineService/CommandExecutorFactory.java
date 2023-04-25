package com.flipkart.CommandLineService;

import com.flipkart.Exceptions.BadCommandException;

import java.util.HashMap;

public class CommandExecutorFactory {
    private HashMap<NewsFeedCommands,ICommand> commandFactory;

    public CommandExecutorFactory(){
        commandFactory=new HashMap<>();
        commandFactory.put(NewsFeedCommands.SIGNUP,new SIGNUPCommand());
        commandFactory.put(NewsFeedCommands.LOGIN,new LOGINCommand());
        commandFactory.put(NewsFeedCommands.POST,new POSTCommand());
        commandFactory.put(NewsFeedCommands.FOLLOW,new FOLLOWCommand());
    }

    public ICommand getCommandExecutor(NewsFeedCommands newsFeedCommand) throws BadCommandException {
        if(!commandFactory.containsKey(newsFeedCommand)){
            throw new BadCommandException("No Command exists with the entered text");
        }
        return commandFactory.get(newsFeedCommand);
    }
}
