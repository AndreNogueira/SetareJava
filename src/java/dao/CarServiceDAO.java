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
            listRes = session.createCriteria(CarService.class, "car_service")
                    .createAlias("car_service.car", "car")
                    .createAlias("car_service.subsidiaryByPickUpSubsidiaryId", "pickUp")
                    .createAlias("pickUp.agency", "agency")
                    .createAlias("pickUp.city", "cityPick")
                    .createAlias("cityPick.country", "countryPick")
                    .createAlias("car_service.subsidiaryByDropOffSubsidiaryId", "dropOff")
                    .add(Restrictions.eq("user.id", idUser))
                    .list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return listRes;
    }
}
