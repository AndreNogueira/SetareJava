package actions.taxis;

import com.opensymphony.xwork2.ActionSupport;
import dao.CountryDAO;
import java.util.Map;
import org.apache.struts2.convention.annotation.Namespace;

@Namespace("/taxis")
public class IndexAction extends ActionSupport {
    
    private CountryDAO countryDAO;
    private Map<String,String> countries;
    
    public IndexAction() {
    }
    
    @Override
    public String execute() throws Exception {
        this.countryDAO = new CountryDAO();
        setCountries(this.countryDAO.taxis());
        return SUCCESS;
    }
    
    /* Getters and Setters */
    public Map<String,String> getCountries() {
        return countries;
    }

    public void setCountries(Map<String,String> countries) {
        this.countries = countries;
    }
    
    
}
