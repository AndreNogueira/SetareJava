package actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Namespace;

@Namespace("/users")
public class RegisterPageAction extends ActionSupport {
    
    public RegisterPageAction() {
    }
    
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
    
}
