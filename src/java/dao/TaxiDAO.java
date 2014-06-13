package dao;

import java.util.List;
import model.Taxi;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class TaxiDAO extends AbstractDAO<Taxi> {
    
    public List<Taxi> searchTaxisWithPassengers(Integer idPickUp, Integer passengers){
        Criteria crit = super.getSession().createCriteria(Taxi.class,"taxi");
        crit.createAlias("taxi.pickUpLocations", "pickUpLocation");
        crit.add(Restrictions.eq("pickUpLocation.id", idPickUp));
        crit.add(Restrictions.ge("taxi.passengersNumber", passengers));
        return crit.list();
    }

}
