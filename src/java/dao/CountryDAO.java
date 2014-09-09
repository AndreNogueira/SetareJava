package dao;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import model.Country;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import utils.GenericDAO;

public class CountryDAO extends GenericDAO<Country> {

    @SuppressWarnings("unchecked")
    public Map<String, String> taxis() {
        List res = null;
        Session session = getSession();
        session.beginTransaction();
        try {
            res = session.createCriteria(Country.class, "country")
                    .createCriteria("cities", "city",
                            JoinType.INNER_JOIN, Restrictions.eq("city.isTaxi", true))
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return createMapCountry(res);
    }

    @SuppressWarnings("unchecked")
    public Map<String, String> countries_with_subs() {
        List res = null;
        Session session = getSession();
        session.beginTransaction();
        try {
            res = session.createCriteria(Country.class, "country")
                    .createCriteria("cities", "city", JoinType.INNER_JOIN)
                    .createCriteria("city.subsidiaries", "sub", JoinType.INNER_JOIN)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return createMapCountry(res);
    }

    @SuppressWarnings("unchecked")
    private Map<String, String> createMapCountry(List<Country> list) {
        Map<String, String> result = new TreeMap<>();
        for (Country c : list) {
            result.put(c.getName(), c.getId().toString());
        }
        return result;
    }
}
