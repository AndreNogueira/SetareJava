package actions.taxis;

import com.opensymphony.xwork2.ActionSupport;
import dao.CountryDAO;
import java.util.Map;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

@ParentPackage("interceptors")
@InterceptorRef(value = "loginStack")
@Namespace("/taxis")
public class IndexTaxiAction extends ActionSupport {
    
    private CountryDAO countryDAO;
    private Map<String,String> countries;
    
    
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
