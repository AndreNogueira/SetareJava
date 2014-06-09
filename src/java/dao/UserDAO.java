package dao;

import java.util.List;
import model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;


public class UserDAO extends AbstractDAO<User>{
    
    public User findByEmail(String email){
        Criteria c = super.getSession().createCriteria(User.class);
        c.add(Restrictions.eq("email", email));
        return (User) c.uniqueResult();
    }
    /**
     * @param email
     * @param id Current user_id
     *
     * Check if email is already in use when update user profile
     * @return Return true if the email is available for user.
     */
    public boolean checkEmail(String email, int id){
        boolean flag_available = false;
        Criteria c = super.getSession().createCriteria(User.class);
        c.add(Restrictions.eq("email", email))
        .add(Restrictions.not(Restrictions.eq("id", id)));
        List<User> lst = c.list();
        if(lst.isEmpty()){
            flag_available = true;
        }
        return flag_available;
    }
    
}
