package dao;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import model.PickUpLocation;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class PickUpLocationDAO extends AbstractDAO<PickUpLocation> {

    public Map<String, String> getPickUpLocationsByCity(Integer id) {
        Criteria crit = super.getSession().createCriteria(PickUpLocation.class);
        crit.add(Restrictions.eq("city.id", id));
        return createMapPickUpLocations(crit.list());
    }

    private Map<String, String> createMapPickUpLocations(List<PickUpLocation> list) {
        Map<String, String> result = new TreeMap<>();
        for (PickUpLocation c : list) {
            result.put(c.getId().toString(), c.getName());
        }
        return result;
    }

}
