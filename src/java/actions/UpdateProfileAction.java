package actions;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDAO;
import java.util.Map;
import model.User;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;


@ParentPackage("interceptors")
@InterceptorRef(value = "loginStack")
@Namespace("/users")
@Results({  @Result(name="success",location="profile-page.jsp"),
    @Result(name="input", location = "profile-page.jsp"),
    @Result(name="error", location = "profile-page.jsp")})
public class UpdateProfileAction extends ActionSupport implements SessionAware{
    private User user;
    private UserDAO userDAO;
    private Map<String, Object> session;
    
    @Override
    public String execute() throws Exception{
        user_update(user);
        return SUCCESS;
    }
    
    public void user_update(User u){
        userDAO = new UserDAO();
        User current_user = (User)this.session.get("user");
        if(userDAO.checkEmail(getUser().getEmail(), current_user.getId())){
            current_user.setAddress(getUser().getAddress());
            current_user.setBi(getUser().getBi());
            current_user.setDriverLicense(getUser().getDriverLicense());
            current_user.setName(getUser().getName());
            current_user.setNif(getUser().getNif());
            current_user.setPhoneNumber(getUser().getPhoneNumber());
            current_user.setEmail(getUser().getEmail());
            if(userDAO.update(current_user)){
                addActionMessage("Your Profile has been successfully updated.");
            }
        }else{
            addActionError("The current email address has already been taked.");
        }
    }
    
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
}
