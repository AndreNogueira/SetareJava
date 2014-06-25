/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package actions.cars;

import com.opensymphony.xwork2.ActionSupport;
import dao.CountryDAO;
import java.util.List;
import model.Country;
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
    
    private List<Country> countries;
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
    
    public List<Country> getCountries() {
        return countries;
    }
    
    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
    
    public CountryDAO getCountryDAO() {
        return countryDAO;
    }
    
    public void setCountryDAO(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }
}
