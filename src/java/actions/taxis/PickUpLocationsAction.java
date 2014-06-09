package actions.taxis;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@ParentPackage("json-actions")
@Namespace("/taxis")
@Result(type = "json")
public class PickUpLocationsAction extends ActionSupport {
    
    private Integer id;
    
    public PickUpLocationsAction() {
    }
    
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    /* Getters and Setters */
    
    public void setId(Integer id) {
        this.id = id;
    }
    
}
