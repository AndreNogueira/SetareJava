package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import model.Subsidiary;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import utils.GenericDAO;

public class SubsidiaryDAO extends GenericDAO<Subsidiary> {

    @SuppressWarnings("unchecked")
    public Map<String, String> pick_subsidiaries(Integer city_id) {
        List res = null;
        Session session = getSession();
        session.beginTransaction();
        try {
            res = session.createCriteria(Subsidiary.class, "subsidiary")
                    .add(Restrictions.eq("city.id", city_id))
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return createMapSubsidiaries(res);
    }

    @SuppressWarnings("unchecked")
    public Map<String, String> drop_subsidiaries(Integer city_id, Integer agency_id) {
        List res = null;
        Session session = getSession();
        session.beginTransaction();
        try {
            res = session.createCriteria(Subsidiary.class, "subsidiary")
                    .add(Restrictions.eq("city.id", city_id))
                    .add(Restrictions.eq("agency.id", agency_id))
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return createMapSubsidiaries(res);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Integer> other_subsidiaries(int pick_city_id, int drop_city_id, int pick_subsidiary_id) {

        List<Subsidiary> pick = searchForCityID(pick_city_id);
        List<Subsidiary> drop = searchForCityID(drop_city_id);
        int agency_id = find(pick_subsidiary_id).getAgency().getId();

        //get the remaining existing subsidiaries from same agency at pick city and drop
        ArrayList<Integer> other_subs_array = new ArrayList<>();
        for (Subsidiary p : pick) {
            for (Subsidiary d : drop) {
                if ((p.getAgency().getId().equals(d.getAgency().getId())) && (p.getAgency().getId() != agency_id)) {
                    other_subs_array.add(p.getId());
                }
            }
        }
        return other_subs_array;
    }

    @SuppressWarnings("unchecked")
    public List searchForCityID(int cityID) {
        List res = null;
        Session session = getSession();
        session.beginTransaction();
        try {
            res = session.createCriteria(Subsidiary.class, "subsidiary")
                    .add(Restrictions.eq("city.id", cityID))
                    .list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return res;
    }

    @SuppressWarnings("unchecked")
    private Map<String, String> createMapSubsidiaries(List<Subsidiary> list) {
        Map<String, String> result = new TreeMap<>();
        for (Subsidiary c : list) {
            result.put(c.getName(), c.getId().toString());
        }
        return result;
    }

}
