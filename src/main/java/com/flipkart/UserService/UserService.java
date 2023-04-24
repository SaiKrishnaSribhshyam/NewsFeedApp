package com.flipkart.UserService;

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
        User user=new User.UserBuilder()
                .setUserName(userName)
                .buildUser();
        return userRepo.isUserPresent(user);
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

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }
}
