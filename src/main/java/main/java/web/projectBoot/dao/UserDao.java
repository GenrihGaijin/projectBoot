package main.java.web.projectBoot.dao;

import main.java.web.projectBoot.model.User;

import java.util.List;


public interface UserDao {
    List<User> getAllUsers();
    void addUser(User user);
    User show(int id);
    void update(User updatedUser);
    void delete(int id);
}
