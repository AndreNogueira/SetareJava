package utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private final static StandardServiceRegistry serviceRegistry;

    /* build a SessionFactory   */
    static {
        try {
            Configuration configuration = new Configuration().configure();
            configuration.setSessionFactoryObserver(
                    new SessionFactoryObserver() {
                        @Override
                        public void sessionFactoryCreated(SessionFactory sf) {}

                        @Override
                        public void sessionFactoryClosed(SessionFactory sf) {
                            ((StandardServiceRegistryImpl) serviceRegistry).destroy();
                        }
                    }
            );
            serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
