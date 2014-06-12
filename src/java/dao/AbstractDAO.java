package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AbstractDAO<T> {

    private final Class classe;
    private final Session session;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    protected Session getSession() {
        return this.session;
    }

    public boolean create(T t) {
        boolean flag = false;
        Transaction trans = session.beginTransaction();
        try {
            session.save(t);
            trans.commit();
            flag = true;
        } catch (Exception e) {
            trans.rollback();
            flag = false;
        } finally {
            session.disconnect();            
        }
        return flag;
    }

    public boolean update(T t) {
        boolean flag = false;
        Transaction trans = session.beginTransaction();
        try {
            session.update(t);
            trans.commit();
            flag = true;
        } catch (Exception e) {
            trans.rollback();
            flag = false;
        } finally {
            session.disconnect();
        }
        return flag;
    }

    public void delete(T t) {
        Transaction trans = session.beginTransaction();
        try {
            session.delete(t);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            session.disconnect();
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return session.createCriteria(this.classe).list();
    }

    @SuppressWarnings("unchecked")
    public T find(Integer id) {
        return (T) session.get(classe, id);

    }

    public int count() {
        return ((Long) session.createQuery("select count(*) from " + classe.getName())
                .list().get(0)).intValue();
    }
   
}

