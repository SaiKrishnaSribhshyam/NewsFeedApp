package com.flipkart.PostService;

import com.flipkart.Exceptions.InvalidPostException;

public class PostService {
    private PostRepo postRepo;
    private static PostService postServiceInstance;

    private PostService(){
        this.postRepo=PostRepo.getInstance();
    }

    public static PostService getInstance(){
        if(postServiceInstance==null){
            synchronized (PostService.class){
                if(postServiceInstance==null){
                    postServiceInstance=new PostService();
                }
            }
        }
        return postServiceInstance;
    }

    public void savePost(Post post){
        int id= postRepo.savePost(post);
        post.setId(id);
    }

    public void saveComment(Post post,Post comment){
        savePost(comment);
        post.addComment(comment);
    }

    public Post getPost(int id) throws InvalidPostException {
        return postRepo.getPost(id);
    }
}
