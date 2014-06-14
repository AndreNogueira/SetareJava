package actions.taxis;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Namespace;

@Namespace("/taxis")
public class ReserveTaxisAction extends ActionSupport {
    
    public ReserveTaxisAction() {
    }
    
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
    
}
