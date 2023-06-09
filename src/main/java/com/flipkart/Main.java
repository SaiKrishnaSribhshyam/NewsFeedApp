package com.flipkart;

import com.flipkart.CommandLineService.CommandExecutorFactory;
import com.flipkart.CommandLineService.NewsFeedCommands;
import com.flipkart.Exceptions.BadCommandException;
import com.flipkart.Exceptions.InvalidPostException;
import com.flipkart.Exceptions.InvalidUserException;
import com.flipkart.Exceptions.UserAlreadyExistsException;

import java.util.Scanner;

public class Main {
    private static final CommandExecutorFactory commandExecutorFactory=CommandExecutorFactory.getInstance();
    public static void main(String[] args) {
        String str="\t welcome";
        System.out.println(str);

        Scanner cin=new Scanner(System.in);
        System.out.println("Select your option, type exit once done");
        System.out.println("Valid Commands");
        System.out.println("SIGNUP LOGIN FOLLOW POST REPLY UPVOTE DOWNVOTE SHOWNEWSFEED");
        while(true){
            System.out.print("NewsFeedApp>");
            String command=cin.nextLine();
            if(command.equals("exit"))
                break;
            String[] commandLine=command.split(" ");
            boolean isValidCommand=false;
            for(NewsFeedCommands keyword:NewsFeedCommands.values()){
                if(commandLine[0].toUpperCase().equals(keyword.toString()) && commandLine.length>=keyword.getMinimumLength()){
                    isValidCommand=true;
                }
            }
            try {
                if(!isValidCommand)
                    throw new BadCommandException("Command Incorrect, try again!");
                commandExecutorFactory.getCommandExecutor(NewsFeedCommands.valueOf(commandLine[0].toUpperCase())).execute(commandLine);
            }  catch (BadCommandException | UserAlreadyExistsException | InvalidPostException | InvalidUserException e) {
                System.out.println(e.getMessage());
            }
        }
        cin.close();

    }
}