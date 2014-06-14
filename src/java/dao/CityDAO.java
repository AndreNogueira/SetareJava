package dao;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import model.City;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

public class CityDAO extends AbstractDAO<City> {
    
    public Map<String,String> taxis(Integer idCountry) {
        Criteria crit = super.getSession().createCriteria(City.class);
        crit.add(Restrictions.conjunction()
                .add(Restrictions.eq("country.id", idCountry))
                .add(Restrictions.eq("isTaxi", true)));
        return createMapCities(crit.list());
    }
    
    private Map<String,String> createMapCities(List<City> list){
        Map<String,String> result = new TreeMap<>();
        for(City c :list)  result.put(c.getName(),c.getId().toString());
        return result;
    }
    
    public Map<String,String> cities_with_subsidiaries (Integer country_id){
        Criteria c = super.getSession().createCriteria(City.class,"city");
        c.createCriteria("subsidiaries", JoinType.INNER_JOIN);
        c.add(Restrictions.eq("city.country.id", country_id));
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return createMapCities(c.list());
    }
    
    public Map<String,String> cities_with_same_agency(int country_id, int agency_id){
         Criteria c = super.getSession().createCriteria(City.class,"city");
        c.createCriteria("subsidiaries", "sub",JoinType.INNER_JOIN,Restrictions.eq("sub.agency.id", agency_id));
        c.add(Restrictions.eq("city.country.id", country_id));
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return createMapCities(c.list());        
    }
}
