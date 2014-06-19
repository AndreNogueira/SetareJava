package actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

@ParentPackage("interceptors")
@InterceptorRef(value = "loginStack")
@Namespace("/users")
public class LoginPageAction extends ActionSupport {

    public LoginPageAction() {
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

}
