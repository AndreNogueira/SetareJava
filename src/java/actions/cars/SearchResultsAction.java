/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package actions.cars;

import beans.CarForm;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author pjmaia
 */
@Namespace("/cars")
public class SearchResultsAction extends ActionSupport implements SessionAware{
    
    private Map<String,Object> session;
    private CarForm results_params;
    
    @Override
    public String execute() throws Exception{   
        System.out.println("******************  "+getResults_params().getDrop_date());
        return SUCCESS;
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
    
    public CarForm getResults_params() {
        return results_params;
    }
    
    public void setResults_params(CarForm results_params) {
        this.results_params = results_params;
    }
}
