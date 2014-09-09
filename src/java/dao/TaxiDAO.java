package dao;

import java.util.List;
import model.Taxi;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import utils.GenericDAO;

public class TaxiDAO extends GenericDAO<Taxi> {

    @SuppressWarnings("unchecked")
    public List<Taxi> searchTaxisWithPassengers(Integer idPickUp, Integer passengers) {
        List res = null;
        Session session = getSession();
        session.beginTransaction();
        try {
            res = session.createCriteria(Taxi.class, "taxi")
                    .createAlias("taxi.pickUpLocations", "pickUpLocation")
                    .add(Restrictions.eq("pickUpLocation.id", idPickUp))
                    .add(Restrictions.ge("taxi.passengersNumber", passengers))
                    .list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return res;
    }

}
