/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package dao;


import model.Agency;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

/**
 *
 * @author pjmaia
 */
public class AgencyDAO extends AbstractDAO<Object>{
    
    public Agency getAgency(int sub_id){   
        Criteria c = super.getSession().createCriteria(Agency.class,"agency");
        c.createCriteria("subsidiaries","sub", JoinType.INNER_JOIN,Restrictions.eq("sub.id", sub_id));
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);        
        return (Agency)c.uniqueResult();    
    }    
}
