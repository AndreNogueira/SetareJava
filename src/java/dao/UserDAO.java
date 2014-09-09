package dao;

import java.util.ArrayList;
import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import utils.GenericDAO;

public class UserDAO extends GenericDAO<User> {

    public User findByEmail(String email) {
        User res = null;
        Session session = getSession();
        session.beginTransaction();
        try {
            res = (User) session.createCriteria(User.class)
                    .add(Restrictions.eq("email", email))
                    .uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return res;
    }

    /**
     * @param email
     * @param id Current user_id
     *
     * Check if email is already in use when update user profile
     * @return Return true if the email is available for user.
     */
    public boolean checkEmail(String email, int id) {
        ArrayList list = new ArrayList();
        Session session = getSession();
        session.beginTransaction();
        try {
            list = (ArrayList) session.createCriteria(User.class)
                    .add(Restrictions.eq("email", email))
                    .add(Restrictions.not(Restrictions.eq("id", id)))
                    .list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return list.isEmpty();
    }

}
