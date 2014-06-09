package actions.taxis;

import com.opensymphony.xwork2.ActionSupport;
import dao.CityDAO;
import java.util.Map;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@ParentPackage("json-actions")
@Namespace("/taxis")
@Result(type = "json")
public class CountryAction extends ActionSupport {

    private String id;
    private Map<String,String> names;
    private CityDAO cityDAO;

    public CountryAction() {
    }

    @Override
    public String execute() {
        Integer idCountry = new Integer(this.id);
        this.cityDAO = new CityDAO();
        Map<String,String> taxiCities = this.cityDAO.taxis(idCountry);
        setNames(taxiCities);
        return SUCCESS;
    }

    /* Getters and Setters */
    public Map<String, String> getNames() {
        return names;
    }

    public void setNames(Map<String, String> names) {
        this.names = names;
    }
    
 
    public void setId(String id) {
        this.id = id;
    }

}
