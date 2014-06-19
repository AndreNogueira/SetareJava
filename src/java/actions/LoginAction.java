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
@Results({
    @Result(name = "success", location = "/index.jsp"),
    @Result(name = "error", location = "login-page.jsp"),
    @Result(name = "input", location = "login-page.jsp")
})
public class LoginAction extends ActionSupport implements SessionAware {

    private String email;
    private String password;
    private UserDAO userDao;
    private Map<String, Object> session;

    public LoginAction() {
    }

    @Override
    public String execute() throws Exception {
        userDao = new UserDAO();
        User u = userDao.findByEmail(getEmail());
        if (u == null || !u.getPassword().equals(getPassword())) {
            addActionError("Password and E-mail don't match. Please try again");
            return ERROR;
        } else {
            session.put("user", u);
            addActionMessage("Login successfull");
            return SUCCESS;
        }
    }

    @Override
    public void validate() {
        if (getEmail().equals("")) {
            addFieldError("email", "E-mail can't be empty");
        }
        if (getPassword().equals("")) {
            addFieldError("password", "Password can't be empty");
        }
    }

    /* Getters and Setters */
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

}
