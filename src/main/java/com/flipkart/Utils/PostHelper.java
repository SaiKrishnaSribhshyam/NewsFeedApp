package com.flipkart.Utils;

import com.flipkart.Exceptions.InvalidPostException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

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

    public static String getTimeInLanguage(LocalDateTime timeStamp){
        StringBuffer timeInLanguage=new StringBuffer();
        long seconds= LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)-timeStamp.toEpochSecond(ZoneOffset.UTC);

        if(seconds/(60*60*24*30*12)>0){
            int years=(int)seconds/(60*60*24*30*12);
            timeInLanguage.append(years+" years");
        }
        else if(seconds/(60*60*24*30)>0){
            int months=(int)seconds/(60*60*24*30);
            timeInLanguage.append(months+" months");
        }
        else if(seconds/(60*60*24*7)>0){
            int weeks=(int)seconds/(60 *60*24*7);
            timeInLanguage.append(weeks+" weeks");
        }
        else if(seconds/(60*60*24)>0){
            int days=(int)seconds/(60 *60*24);
            timeInLanguage.append(days +" days");
        }
        else if(seconds/(60*60)>0){
            int hours=(int)seconds/(60 * 60);
            timeInLanguage.append(hours +" hours");
        }
        else if(seconds/(60)>0){
            int minutes=(int)seconds/60;
            timeInLanguage.append(minutes +" minutes");
        }
        else {
            timeInLanguage.append("few moments");
        }

        timeInLanguage.append(" ago");
        return timeInLanguage.toString();
    }

}
