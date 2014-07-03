package dao;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import model.Country;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

public class CountryDAO extends AbstractDAO<Country>{
    
    public Map<String,String> taxis(){
        Criteria c = super.getSession().createCriteria(Country.class,"country");
        c.createCriteria("cities", "city", JoinType.INNER_JOIN, Restrictions.eq("city.isTaxi", true));
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);        
        return createMapCountry(c.list());        
    }
    
    private Map<String,String> createMapCountry(List<Country> list){
        Map<String,String> result = new TreeMap<>();
        for(Country c :list)  result.put(c.getName(),c.getId().toString());
        return result;        
    }
    
    public Map<String,String> countries_with_subs(){
        Criteria c = super.getSession().createCriteria(Country.class,"country");
        c.createCriteria("cities", "city", JoinType.INNER_JOIN);
        c.createCriteria("city.subsidiaries", "sub", JoinType.INNER_JOIN);
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return createMapCountry(c.list()); 
    }    
}
