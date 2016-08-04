package usermanager.dao;

import org.springframework.web.bind.annotation.RequestParam;
import usermanager.model.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    private int currentPage = 0;
    private int maxPageCount = 0;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }


    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }


    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, new Integer(id));

        if (user != null) {
            session.delete(user);
        }
    }


    public User getUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, new Integer(id));

        return user;
    }

    public List<User> listUsers() {
        String queryString = "SELECT * FROM users";
        Session session = this.sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery(queryString);
        query.addEntity(User.class);
        List<User> result = query.list();

        this.maxPageCount = result.size() / 2;

        return result;
    }

    public List<User> filterList(String name) {
        String s = "%";
        String queryString = String.format("SELECT * FROM users where name like \"%s%s%s\"", s, name, s);

        Session session = this.sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery(queryString);
        query.addEntity(User.class);
        List<User> result = query.list();

        return result;
    }
}
