package com.flipkart.PostService;

import com.flipkart.Exceptions.InvalidPostException;

import java.util.HashMap;

public class PostRepo {
    private HashMap<Integer,Post> posts;
    private int nextId;
    private static PostRepo postRepoInstance;

    private PostRepo(){
        this.posts=new HashMap<Integer,Post>();
        this.nextId=1;
    }

    public static PostRepo getInstance(){
        if(postRepoInstance==null){
            synchronized (PostRepo.class) {
                if(postRepoInstance==null){
                    postRepoInstance=new PostRepo();
                }
            }
        }
        return postRepoInstance;
    }

    public int savePost(Post post){
        posts.put(nextId,post);
        return nextId++;
    }

    public Post getPost(int id) throws InvalidPostException {
        if(posts.containsKey(id))
            return posts.get(id);
        throw new InvalidPostException("No post exists with given post Id");
    }
}
