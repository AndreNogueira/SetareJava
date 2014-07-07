/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package actions.cars;

import com.opensymphony.xwork2.ActionSupport;
import dao.CountryDAO;
import java.util.Map;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

/**
 *
 * @author pjmaia
 */
@ParentPackage("interceptors")
@InterceptorRef(value = "loginStack")
@Namespace("/cars")
public class IndexAction extends ActionSupport{
    
    private Map<String,String> countries;
    private CountryDAO countryDAO;
    
    @Override
    public String execute() throws Exception{
        load_countries();
        return SUCCESS;
    }
    
    public void load_countries(){
        countryDAO = new CountryDAO();
        setCountries(countryDAO.countries_with_subs());          
    }    
    
    public Map<String,String> getCountries() {
        return countries;
    }
    
    public void setCountries(Map<String,String> countries) {
        this.countries = countries;
    }
    
    public CountryDAO getCountryDAO() {
        return countryDAO;
    }
    
    public void setCountryDAO(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }
}
