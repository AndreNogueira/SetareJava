package dao;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import model.PickUpLocation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import utils.GenericDAO;

public class PickUpLocationDAO extends GenericDAO<PickUpLocation> {

    @SuppressWarnings("unchecked")
    public Map<String, String> getPickUpLocationsByCity(Integer idCity) {
        List res = null;
        Session session = getSession();
        session.beginTransaction();
        try {
            res = session.createCriteria(PickUpLocation.class)
                    .add(Restrictions.eq("city.id", idCity))
                    .list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return createMapPickUpLocations(res);
    }

    @SuppressWarnings("unchecked")
    private Map<String, String> createMapPickUpLocations(List<PickUpLocation> list) {
        Map<String, String> result = new TreeMap<>();
        for (PickUpLocation c : list) {
            result.put(c.getName(), c.getId().toString());
        }
        return result;
    }

}
