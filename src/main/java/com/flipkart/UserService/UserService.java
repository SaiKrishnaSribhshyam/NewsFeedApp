package com.flipkart.UserService;

import com.flipkart.PostService.Post;

public class UserService {
    private UserRepo userRepo;
    private User activeUser;
    private static UserService userServiceInstance;

    private UserService(){
        this.userRepo=UserRepo.INSTANCE;
    }

    public static UserService getInstance(){
        if(userServiceInstance==null){
            synchronized (UserService.class){
                if(userServiceInstance==null)
                    userServiceInstance=new UserService();
            }
        }
        return userServiceInstance;
    }

    public boolean isUserExists(String userName){
        return userRepo.isUserPresent(userName);
    }

    public void addUser(String userName){
        User user=new User.UserBuilder()
                .setUserName(userName)
                .buildUser();
        userRepo.addUser(user);
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(String userName) {
        if(isUserExists(userName))
           this.activeUser = userRepo.getUser(userName);
    }

    public void addFollowee(User followee){
        activeUser.getFollowees().add(followee);
    }

    public void addPost(Post post){
        activeUser.getPosts().add(post);
    }
}
