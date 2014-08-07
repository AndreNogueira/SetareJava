package utils;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

public abstract class GenericDAO<T> {

    private final Class classe;

    @SuppressWarnings("unchecked")
    public GenericDAO() {
        this.classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Session getSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public boolean create(T t) {
        boolean flag = false;
        Session session = getSession();
        session.beginTransaction();
        try {
            session.save(t);
            session.getTransaction().commit();
            flag = true;
        } catch (HibernateException e) {
        }
        return flag;
    }

    @SuppressWarnings("unchecked")
    public boolean update(T t) {
        boolean flag = false;
        Session session = getSession();
        session.beginTransaction();
        try {
            session.update(t);
            session.getTransaction().commit();
            flag = true;
        } catch (HibernateException e) {
        }
        return flag;
    }

    @SuppressWarnings("unchecked")
    public boolean delete(T t) {
        boolean flag = false;
        Session session = getSession();
        session.beginTransaction();
        try {
            session.delete(t);
            session.getTransaction().commit();
            flag = true;
        } catch (HibernateException e) {
        }
        return flag;
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        List res = null;
        Session session = getSession();
        session.beginTransaction();
        try {            
            res = session.createCriteria(this.classe).list();
            session.flush();
            session.getTransaction().commit();
        } catch (HibernateException e) {
        }
        return res;
    }

    @SuppressWarnings("unchecked")
    public T find(Integer id) {
        T res = null;
        Session session = getSession();
        session.beginTransaction();
        try {
            res = (T) session.get(classe, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
        }
        return res;
    }

    public int count() {
        Long res = new Long("0");
        Session session = getSession();
        session.beginTransaction();
        try {
            res = (Long) session.createCriteria(this.classe)
                    .setProjection(Projections.rowCount())
                    .uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateException e) {
        }
        return res.intValue();
    }

}
