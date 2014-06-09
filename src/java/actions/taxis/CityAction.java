package actions.taxis;

import com.opensymphony.xwork2.ActionSupport;
import dao.PickUpLocationDAO;
import java.util.Map;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@ParentPackage("json-actions")
@Namespace("/taxis")
@Result(type = "json")
public class CityAction extends ActionSupport {
    
    private Integer id;
    private Map<String,String> names;
    private PickUpLocationDAO pickUpLocationDAO;
    
    public CityAction() {
    }
    
    @Override
    public String execute() throws Exception {
        this.pickUpLocationDAO = new PickUpLocationDAO();
        setNames(this.pickUpLocationDAO.getPickUpLocationsByCity(id));
        return SUCCESS;
    }
    
    /* Getters and Setters */    
    public Map<String, String> getNames() {
        return names;
    }

    public void setNames(Map<String, String> names) {
        this.names = names;
    }

    public void setId(Integer id) {
        this.id = id;
    }    
}
