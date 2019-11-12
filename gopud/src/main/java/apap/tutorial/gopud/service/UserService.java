package apap.tutorial.gopud.service;


import apap.tutorial.gopud.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);
    public String encrypt(String password);
    UserModel getUserByUsername(String username);
    public boolean checkUsername(String username);
    void changePassword(UserModel user, String newPass);
}
