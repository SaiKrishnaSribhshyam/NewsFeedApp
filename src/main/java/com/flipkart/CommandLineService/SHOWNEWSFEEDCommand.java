package com.flipkart.CommandLineService;

import com.flipkart.Exceptions.BadCommandException;
import com.flipkart.Exceptions.InvalidPostException;
import com.flipkart.Exceptions.InvalidUserException;
import com.flipkart.Exceptions.UserAlreadyExistsException;
import com.flipkart.PostService.Post;
import com.flipkart.PostService.PostService;
import com.flipkart.UserService.User;
import com.flipkart.UserService.UserService;
import com.flipkart.Utils.PostHelper;

import java.util.List;
import java.util.PriorityQueue;

public class SHOWNEWSFEEDCommand extends ICommand{
    private PostService postService;
    private UserService userService;
    private final int INITIAL_INDENTATION=0;

    public SHOWNEWSFEEDCommand(){
        this.postService=PostService.getInstance();
        this.userService=UserService.getInstance();
    }
    @Override
    public void execute(String[] command) throws BadCommandException, UserAlreadyExistsException, InvalidUserException, InvalidPostException {
        List<User> followees=userService.getActiveUser().getFollowees();
        PriorityQueue<Post> newsFeedQueue=new PriorityQueue<Post>();
        newsFeedQueue.addAll(userService.getActiveUser().getPosts());
        for(User user:followees){
            for(Post post:user.getPosts()){
                newsFeedQueue.add(post);
            }
        }

        while(newsFeedQueue.size()>0) {
            printPost(newsFeedQueue.poll(), INITIAL_INDENTATION);
        }
    }

    public void printPost(Post post,int indentationLevel){
        String indents=getIndentString(indentationLevel);
        System.out.println(indents +"Id:"+post.getId());
        System.out.println(indents +"Posted By:"+post.getUser().getUserName());
        System.out.println(indents +post.getText());
        System.out.println(indents +post.getUpvotes().size()+ " UpVotes,"+post.getDownvotes().size()+" DownVotes");
        System.out.println(indents + PostHelper.getTimeInLanguage(post.getTimeStamp()));

        for(Post comment:post.getComments()){
            printPost(comment,indentationLevel+1);
        }
    }

    public String getIndentString(int indentationLevel){
        StringBuffer indents=new StringBuffer();
        for(int i=0;i<indentationLevel;i++){
            indents.append("\t ");
        }
        return indents.toString();
    }
}
