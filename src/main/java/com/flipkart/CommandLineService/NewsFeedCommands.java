package com.flipkart.CommandLineService;

public enum NewsFeedCommands {
    SIGNUP(2),
    LOGIN(2),
    POST(3),
    FOLLOW(2),
    REPLY(3),
    UPVOTE(2),
    DOWNVOTE(2),
    SHOWNEWSFEED(1);

    private int minimumLength;
    NewsFeedCommands(int minimumLength){
        this.minimumLength=minimumLength;
    }

    public int getMinimumLength(){
        return this.minimumLength;
    }
}
