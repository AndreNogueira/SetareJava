package dao;

import java.util.List;
import model.Country;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

public class CountryDAO extends AbstractDAO<Country>{
    
    public List<Country> taxis(){
        Criteria c = super.getSession().createCriteria(Country.class,"country");
        c.createCriteria("cities", "city", JoinType.INNER_JOIN, Restrictions.eq("city.isTaxi", true));
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return c.list();
    }
    
    public List<Country> countries_with_subs(){
        Criteria c = super.getSession().createCriteria(Country.class,"country");
        c.createCriteria("cities", "city", JoinType.INNER_JOIN);
        c.createCriteria("city.subsidiaries", "sub", JoinType.INNER_JOIN);
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return c.list();
    }
}
