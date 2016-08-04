package usermanager.dao;

import usermanager.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    void updateUser(User user);

    void removeUser(int id);

    User getUser(int id);

    List<User> listUsers();

    List<User> filterList(String name);
}
