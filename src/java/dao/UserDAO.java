package dao;

import model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;


public class UserDAO extends AbstractDAO<User>{
    
    public User findByEmail(String email){        
        Criteria c = super.getSession().createCriteria(User.class);
        c.add(Restrictions.eq("email", email));
        return (User) c.uniqueResult();
    }   
}
