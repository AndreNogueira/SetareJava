package actions.taxis;

import com.opensymphony.xwork2.ActionSupport;
import dao.CountryDAO;
import java.util.List;
import model.Country;
import org.apache.struts2.convention.annotation.Namespace;

@Namespace("/taxis")
public class IndexAction extends ActionSupport {
    
    private CountryDAO countryDAO;
    private List<Country> countries;
    
    public IndexAction() {
    }
    
    @Override
    public String execute() throws Exception {
        this.countryDAO = new CountryDAO();
        setCountries(this.countryDAO.taxis());
        return SUCCESS;
    }
    
    /* Getters and Setters */
    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
    
    
}
