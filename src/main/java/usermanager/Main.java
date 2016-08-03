package usermanager;

import usermanager.dao.UserDao;
import usermanager.dao.UserDaoImpl;

public class Main {
    public static void main(String[] args) {
        String name = "Vania";
        String s = "%";
        String queryString = String.format("SELECT * FROM users where name like \"%s%s%s\"", s, name, s);
        System.out.println(queryString);



/*        for (Object o : userDao.listUsers()){
            User user = (User) o;
            System.out.println(user);
        }*/
    }
}
