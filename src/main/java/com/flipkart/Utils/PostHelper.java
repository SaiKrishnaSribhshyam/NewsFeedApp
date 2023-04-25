package com.flipkart.Utils;

import com.flipkart.Exceptions.InvalidPostException;

import java.time.LocalDateTime;

public class PostHelper {
    public static String getText(String[] command,int offset) throws InvalidPostException {
        StringBuffer text=new StringBuffer();
        int length=command.length;
        if(length<offset)
            throw new InvalidPostException("No content availalbe, POST is invalid");
        for(int i=offset;i<length;i++) {
            text.append(command[i]+' ');
        }
        return text.toString();
    }

}
