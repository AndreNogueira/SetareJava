package dao;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import model.City;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

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
        for(City c :list)  result.put(c.getId().toString(),c.getName());
        return result;
    }

}
