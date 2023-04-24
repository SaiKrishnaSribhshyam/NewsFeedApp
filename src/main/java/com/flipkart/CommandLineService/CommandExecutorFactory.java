package com.flipkart.CommandLineService;

import java.util.HashMap;

public class CommandExecutorFactory {
    private HashMap<NewsFeedCommand,ICommand> commandFactory;

    public CommandExecutorFactory(){
        commandFactory=new HashMap<>();
        commandFactory.put(NewsFeedCommand.SIGNUP,new SIGNUPCommand());
    }

    public ICommand getCommandExecutor(NewsFeedCommand newsFeedCommand){
        if(!commandFactory.containsKey(newsFeedCommand)){
            //throw new exception
        }
        return commandFactory.get(newsFeedCommand);
    }
}
