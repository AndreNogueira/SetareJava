package actions.taxis;

import beans.TaxiCost;
import beans.TaxiForm;
import beans.TaxiLocations;
import businesslogic.TaxiSearch;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Map;
import java.util.Set;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.interceptor.SessionAware;

@Namespace("/taxis")
public class SearchTaxisAction extends ActionSupport implements ModelDriven<TaxiForm>, SessionAware {
    
    private Map<String,Object> session;
    private TaxiForm taxiFormSearch;
    private TaxiLocations taxiLocations;
    private Set<TaxiCost> taxiResults;
    
    public SearchTaxisAction() {
        this.taxiFormSearch = new TaxiForm();
    }
    
    @Override
    public String execute() throws Exception {
        
        this.taxiLocations = new TaxiLocations(this.taxiFormSearch.getCountry(),
                                               this.taxiFormSearch.getCity(), 
                                               this.taxiFormSearch.getPickUpLocation());
        session.put("taxiForm", taxiFormSearch);
        TaxiSearch ts = new TaxiSearch(taxiFormSearch.getPickUpLocation(),
                                       taxiFormSearch.getDropOffLocation(),
                                       taxiFormSearch.getPassengers(), 
                                       taxiFormSearch.getType_trip());
        setTaxiResults(ts.search());
        System.out.println(taxiFormSearch.getBegin_date());
        return SUCCESS;
    }
    
    /* Getters and Setters */

    @Override
    public TaxiForm getModel() {
        return taxiFormSearch;
    }

    public Set<TaxiCost> getTaxiResults() {
        return taxiResults;
    }

    public TaxiLocations getTaxiLocations() {
        return taxiLocations;
    }

    public void setTaxiLocations(TaxiLocations taxiLocations) {
        this.taxiLocations = taxiLocations;
    }
    
    public void setTaxiResults(Set<TaxiCost> taxiResults) {
        this.taxiResults = taxiResults;
    }
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
    
}
