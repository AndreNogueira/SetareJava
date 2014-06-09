package actions.taxis;

import com.opensymphony.xwork2.ActionSupport;
import dao.DropOffLocationDAO;
import dao.PickUpLocationDAO;
import java.util.Map;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@ParentPackage("json-actions")
@Namespace("/taxis")
@Result(type = "json")
public class PickUpLocationsAction extends ActionSupport {

    private Integer id;
    private Map<String, String> names;
    private DropOffLocationDAO dropOffLocationDAO;

    public PickUpLocationsAction() {
    }

    @Override
    public String execute() throws Exception {
        this.dropOffLocationDAO = new DropOffLocationDAO();
        setNames(this.dropOffLocationDAO.getDropOffLocationsByIdPickUp(id));        
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
