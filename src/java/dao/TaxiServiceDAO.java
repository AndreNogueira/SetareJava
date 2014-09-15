package dao;

import java.util.List;
import model.TaxiService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import utils.GenericDAO;

public class TaxiServiceDAO extends GenericDAO<TaxiService> {

    @SuppressWarnings("unchecked")
    public List<TaxiService> getTaxiServicesFromUser(Integer idUser) {
        List res = null;
        Session session = getSession();
        session.beginTransaction();
        try {
            res = session.createCriteria(TaxiService.class, "taxiService")
                    .createAlias("taxiService.taxi", "taxi")
                    .add(Restrictions.eq("user.id", idUser))
                    .list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return res;
    }

}
