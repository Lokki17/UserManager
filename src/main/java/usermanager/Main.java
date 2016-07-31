package usermanager;

import usermanager.dao.UserDao;
import usermanager.dao.UserDaoImpl;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();

        System.out.println(userDao.getUser(1));


/*        for (Object o : userDao.listUsers()){
            User user = (User) o;
            System.out.println(user);
        }*/
    }
}
