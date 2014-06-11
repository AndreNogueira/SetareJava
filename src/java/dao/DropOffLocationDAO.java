package dao;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import model.DropOffLocation;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class DropOffLocationDAO extends AbstractDAO<DropOffLocation> {

    public Map<String, String> getDropOffLocationsByIdPickUp(Integer idPickUp) {
        Criteria crit = super.getSession().createCriteria(DropOffLocation.class, "dp");
        crit.createAlias("dp.pickUpLocations", "p");
        crit.add(Restrictions.eq("p.id", idPickUp));
        return createMapDropOffLocations(crit.list());
    }

    private Map<String, String> createMapDropOffLocations(List<DropOffLocation> list) {
        Map<String, String> result = new TreeMap<>();
        for (DropOffLocation c : list) {
            result.put( c.getName(),c.getId().toString());
        }
        return result;
    }

}
