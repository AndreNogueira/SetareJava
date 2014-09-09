package dao;

import model.Agency;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import utils.GenericDAO;

public class AgencyDAO extends GenericDAO<Agency> {

    public Agency getAgency(int sub_id) {
        Agency res = null;
        Session session = getSession();
        session.beginTransaction();
        try {
            res = (Agency) session.createCriteria(Agency.class, "agency")
                    .createCriteria("subsidiaries", "sub", 
                            JoinType.INNER_JOIN, 
                            Restrictions.eq("sub.id", sub_id))
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return res;
    }
}
