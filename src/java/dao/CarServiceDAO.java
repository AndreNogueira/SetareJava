package dao;

import java.util.Date;
import java.util.List;
import model.CarService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import utils.GenericDAO;

public class CarServiceDAO extends GenericDAO<CarService> {

    @SuppressWarnings("unchecked")
    public List<CarService> services(int car_id) {
        List<CarService> listRes = null;
        Session session = getSession();
        session.beginTransaction();
        try {
            listRes = session.createCriteria(CarService.class, "car_service")
                    .add(Restrictions.eq("car.id", car_id))
                    .add(Restrictions.eq("serviceEnd", new Date()))
                    .list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return listRes;
    }

    @SuppressWarnings("unchecked")
    public List<CarService> getCarServicesFromUser(Integer idUser) {
        List<CarService> listRes = null;
        Session session = getSession();
        session.beginTransaction();
        try {
            listRes = session.createCriteria(CarService.class, "carService")
                    .add(Restrictions.eq("user.id", idUser))
                    .list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return listRes;
    }
}
