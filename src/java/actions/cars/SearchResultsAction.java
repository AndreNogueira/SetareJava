/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package actions.cars;

import beans.CarCost;
import beans.CarForm;
import beans.CarLocations;
import businesslogic.CarSearch;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.List;
import java.util.Map;
import java.util.Set;
import model.Car;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author pjmaia
 */
@Namespace("/cars")
public class SearchResultsAction extends ActionSupport implements SessionAware,ModelDriven<CarForm>{
    
    private Map<String,Object> session;
    private CarForm results_params;
    private CarLocations locations;
    private Set<CarCost> list_selected_subsidiary;
    private Map<Integer,Set<CarCost>> other_agencies_list;
    
    
    public SearchResultsAction() {
        this.results_params = new CarForm();
    }
    
    @Override
    public String execute() throws Exception{
        process_results();
        load_params(results_params);
        
        return SUCCESS;
    }
    
    public void process_results(){
        if(results_params.getReturn_at_same_location() == true){
            results_params.setDrop_city(results_params.getPick_city());
            results_params.setDrop_subsidiary(results_params.getPick_subsidiary());
        }
        session.put("service_params", results_params);
        
        CarSearch search = new CarSearch(results_params.getPick_subsidiary(),
                results_params.getPick_date(),
                results_params.getDrop_date(),
                results_params.getPick_city(),
                results_params.getDrop_city());
        
        this.other_agencies_list = search.getOther_agencies_list();
        this.list_selected_subsidiary = search.getList_selected_subsidiary();
    }
    public void load_params(CarForm cf){
        this.locations = new CarLocations(cf.getPick_country(),
                cf.getPick_city(),
                cf.getPick_subsidiary(),
                cf.getDrop_city());
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
    
    @Override
    public CarForm getModel() {
        return results_params; //To change body of generated methods, choose Tools | Templates.
    }
    
    public CarLocations getLocations() {
        return locations;
    }
    
    public void setLocations(CarLocations locations) {
        this.locations = locations;
    }
    
    
    public CarForm getResults_params() {
        return results_params;
    }
    
    public void setResults_params(CarForm results_params) {
        this.results_params = results_params;
    }
    
    public Set<CarCost> getList_selected_subsidiary() {
        return list_selected_subsidiary;
    }
    
    public void setList_selected_subsidiary(Set<CarCost> list_selected_subsidiary) {
        this.list_selected_subsidiary = list_selected_subsidiary;
    }
    
    public Map<Integer, Set<CarCost>> getOther_agencies_list() {
        return other_agencies_list;
    }
    
    public void setOther_agencies_list(Map<Integer, Set<CarCost>> other_agencies_list) {
        this.other_agencies_list = other_agencies_list;
    }
    
}
