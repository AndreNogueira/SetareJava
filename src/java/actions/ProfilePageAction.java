
package actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import model.User;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.SessionAware;

@ParentPackage("interceptors")
@InterceptorRef(value = "loginStack")
@Namespace("/users")
public class ProfilePageAction extends ActionSupport implements SessionAware{
    private User user;
    private Map<String, Object> session;
    
    @Override
    public String execute() throws Exception{
        load_user_data();
        return SUCCESS;
    }
    
    private void load_user_data(){
        this.user = (User) this.session.get("user");
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
    
    public User getUser() {
        return user;
    }
    
}
