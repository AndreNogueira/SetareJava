package actions;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDAO;
import dao.UserProfileDAO;
import model.User;
import model.UserProfile;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespace("/users")
@Result(name="success",location="login-page.jsp") //mandar isto pra uma página qq de sucesso.. index?
public class RegisterPageAction extends ActionSupport {
    private User user;
    
    public RegisterPageAction() {
    }
    
    
    @Override
    public String execute() throws Exception {
        create_user(user);
        return SUCCESS;
    } 
    
    public User getUser() {
         
        return user;
         
    }
     
    public void setUser(User user) {
         
        this.user = user;
         
    }
    
    
    public void create_user(User u){
        UserProfile up;
        UserProfileDAO upDAO = new UserProfileDAO();
        up = upDAO.find(1);
        
        UserDAO uDAO = new UserDAO();      
        u.setUserProfile(up);
        uDAO.create(u); 
    }
    
}
