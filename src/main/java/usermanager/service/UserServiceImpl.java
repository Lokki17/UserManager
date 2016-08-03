package usermanager.service;

import usermanager.dao.UserDao;
import usermanager.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Transactional
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    @Transactional
    public void removeUser(int id) {
        this.userDao.removeUser(id);
    }

    @Transactional
    public User getUser(int id) {
        return this.userDao.getUser(id);
    }

    @Transactional
    public List<User> listUsers() {
        return this.userDao.listUsers();
    }

    public List<User> filterList(String name) {
        return this.userDao.filterList(name);
    }
}
