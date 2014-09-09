package dao;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import model.DropOffLocation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import utils.GenericDAO;

public class DropOffLocationDAO extends GenericDAO<DropOffLocation> {

    @SuppressWarnings("unchecked")
    public Map<String, String> getDropOffLocationsByIdPickUp(Integer idPickUp) {
        List res = null;
        Session session = getSession();
        session.beginTransaction();
        try {
            res = session.createCriteria(DropOffLocation.class, "dp")
                    .createAlias("dp.pickUpLocations", "p")
                    .add(Restrictions.eq("p.id", idPickUp))
                    .list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return createMapDropOffLocations(res);
    }

    @SuppressWarnings("unchecked")
    private Map<String, String> createMapDropOffLocations(List<DropOffLocation> list) {
        Map<String, String> result = new TreeMap<>();
        for (DropOffLocation c : list) {
            result.put(c.getName(), c.getId().toString());
        }
        return result;
    }

}
