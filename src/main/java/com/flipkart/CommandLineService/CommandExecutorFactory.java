package com.flipkart.CommandLineService;

import com.flipkart.Exceptions.BadCommandException;

import java.util.HashMap;

public class CommandExecutorFactory {
    private HashMap<NewsFeedCommands,ICommand> commandFactory;
    private static CommandExecutorFactory commandExecutorFactoryInstance;

    private CommandExecutorFactory(){
        commandFactory=new HashMap<>();
        commandFactory.put(NewsFeedCommands.SIGNUP,new SIGNUPCommand());
        commandFactory.put(NewsFeedCommands.LOGIN,new LOGINCommand());
        commandFactory.put(NewsFeedCommands.POST,new POSTCommand());
        commandFactory.put(NewsFeedCommands.FOLLOW,new FOLLOWCommand());
        commandFactory.put(NewsFeedCommands.REPLY,new REPLYCommand());
        commandFactory.put(NewsFeedCommands.UPVOTE,new UPVOTECommand());
        commandFactory.put(NewsFeedCommands.DOWNVOTE,new DOWNVOTECommand());
        commandFactory.put(NewsFeedCommands.SHOWNEWSFEED,new SHOWNEWSFEEDCommand());
    }

    public static CommandExecutorFactory getInstance(){
        if(commandExecutorFactoryInstance==null){
            synchronized (CommandExecutorFactory.class){
                if(commandExecutorFactoryInstance==null)
                    commandExecutorFactoryInstance=new CommandExecutorFactory();
            }
        }
        return commandExecutorFactoryInstance;
    }

    public ICommand getCommandExecutor(NewsFeedCommands newsFeedCommand) throws BadCommandException {
        if(!commandFactory.containsKey(newsFeedCommand)){
            throw new BadCommandException("No Command exists with the entered text");
        }
        return commandFactory.get(newsFeedCommand);
    }
}
