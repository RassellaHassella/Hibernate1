package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private static final SessionFactory factory = new Configuration()
            .configure("Util")
            .addAnnotatedClass(User.class)
            .buildSessionFactory();

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Transaction tx = null;
        try (Session session = factory.getCurrentSession();) {
            tx = session.beginTransaction();
            session.createNativeQuery("CREATE TABLE IF NOT EXISTS User " +
                            "(Id BIGINT PRIMARY KEY AUTO_INCREMENT, name TINYTEXT, lastName TINYTEXT, age TINYINT)")
                    .addEntity(User.class).executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void dropUsersTable() {
        Transaction tx = null;
        try (Session session = factory.getCurrentSession();) {
            tx = session.beginTransaction();
            session.createNativeQuery("DROP TABLE IF EXISTS User")
                    .addEntity(User.class).executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction tx = null;
        try (Session session = factory.getCurrentSession();) {
            tx = session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction tx = null;
        try (Session session = factory.getCurrentSession();) {
           tx = session.beginTransaction();
            session.remove(id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<User> getAllUsers() {
        Transaction tx = null;
        List<User> userList = null;
        try (Session session = factory.getCurrentSession();) {
            tx = session.beginTransaction();
            userList = session.createQuery("from User").getResultList();
            for (User e : userList) {
                System.out.println(e);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                e.printStackTrace();
            }
        }
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        Transaction tx = null;
        try (Session session = factory.getCurrentSession();) {
            tx = session.beginTransaction();
            session.createNativeQuery("TRUNCATE TABLE User").executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                e.printStackTrace();
            }
        }
    }
}
