package usermanager.dao;

import usermanager.model.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));

        if(user !=null){
            session.delete(user);
        }
    }

    @Override
    public User getUser(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, new Integer(id));

        return user;
    }

    public List<User> listUsers() {
        String queryString = "SELECT * FROM users";
        Session session = this.sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery(queryString);
        query.addEntity(User.class);
        List<User> result = query.list();

        return result;
    }
}
