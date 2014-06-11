package dao;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import model.PickUpLocation;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class PickUpLocationDAO extends AbstractDAO<PickUpLocation> {

    public Map<String, String> getPickUpLocationsByCity(Integer idCity) {
        Criteria crit = super.getSession().createCriteria(PickUpLocation.class);
        crit.add(Restrictions.eq("city.id", idCity));
        return createMapPickUpLocations(crit.list());
    }

    private Map<String, String> createMapPickUpLocations(List<PickUpLocation> list) {
        Map<String, String> result = new TreeMap<>();
        for (PickUpLocation c : list) {
            result.put(c.getName(),c.getId().toString());
        }
        return result;
    }

}
