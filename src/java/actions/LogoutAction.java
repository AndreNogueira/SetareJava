package actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

@Namespace("/users")
@Result(name = "success", location = "/index.jsp")
public class LogoutAction extends ActionSupport implements SessionAware {
    
    private Map<String,Object> session;
    public LogoutAction() {
    }
    
    @Override
    public String execute() throws Exception {
        addActionMessage("Logout Successfull");
        session.remove("user");        
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) { this.session = map;}
    
}
