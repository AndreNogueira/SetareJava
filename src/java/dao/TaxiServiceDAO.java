package dao;

import java.util.List;
import model.TaxiService;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class TaxiServiceDAO extends AbstractDAO<TaxiService>{
    
    public List<TaxiService> getTaxiServicesFromUser(Integer idUser){
        Criteria crit = super.getSession().createCriteria(TaxiService.class, "taxiService");
        crit.add(Restrictions.eq("user.id", idUser));
        return crit.list();        
    }
    
}
