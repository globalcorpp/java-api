package ir.rnd.service;

import ir.rnd.model.User;

import java.util.List;

public interface UserService {
    User findById(long id);

    User findByName(String name);

    User saveUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

    List<User> findAllUsers();

    void deleteAllUsers();

    public boolean isUserExist(User user);
}
