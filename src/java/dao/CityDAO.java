package dao;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import model.City;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import utils.GenericDAO;

public class CityDAO extends GenericDAO<City> {

    @SuppressWarnings("unchecked")
    public Map<String, String> taxis(Integer idCountry) {
        List res = null;
        Session session = getSession();
        session.beginTransaction();
        try {
            res = session.createCriteria(City.class)
                    .add(Restrictions.conjunction()
                            .add(Restrictions.eq("country.id", idCountry))
                            .add(Restrictions.eq("isTaxi", true)))
                    .list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return createMapCities(res);
    }

    @SuppressWarnings("unchecked")
    public Map<String, String> cities_with_subsidiaries(Integer country_id) {
        List res = null;
        Session session = getSession();
        session.beginTransaction();
        try {
            res = session.createCriteria(City.class, "city")
                    .createCriteria("subsidiaries", JoinType.INNER_JOIN)
                    .add(Restrictions.eq("city.country.id", country_id))
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return createMapCities(res);
    }

    @SuppressWarnings("unchecked")
    public Map<String, String> cities_with_same_agency(int country_id, int agency_id) {
        List res = null;
        Session session = getSession();
        session.beginTransaction();
        try {
            res = session.createCriteria(City.class, "city")
                    .createCriteria("subsidiaries", "sub",
                            JoinType.INNER_JOIN, Restrictions.eq("sub.agency.id", agency_id))
                    .add(Restrictions.eq("city.country.id", country_id))
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return createMapCities(res);
    }

    private Map<String, String> createMapCities(List<City> list) {
        Map<String, String> result = new TreeMap<>();
        for (City c : list) {
            result.put(c.getName(), c.getId().toString());
        }
        return result;
    }
}
