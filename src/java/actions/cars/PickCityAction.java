/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package actions.cars;

import com.opensymphony.xwork2.ActionSupport;
import dao.CityDAO;
import java.util.Map;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author pjmaia
 */
@ParentPackage("json-actions")
@Namespace("/cars")
@Result(type = "json")
public class PickCityAction extends ActionSupport{
    
    private Integer id;
    private Map<String,String> names;
    private Integer id2;
    
    @Override
    public String execute() throws Exception{
        load_pick_cities(id);
        return SUCCESS;
    }
    
    public void load_pick_cities(int pick_country_id){
        CityDAO cityDAO = new CityDAO();
        Map<String,String> carCities = cityDAO.cities_with_subsidiaries(pick_country_id);
        setNames(carCities);
    }
    
    public Map<String, String> getNames() {
        return names;
    }
    
    public void setNames(Map<String, String> names) {
        this.names = names;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId2() {
        return id2;
    }
    
    public void setId2(Integer id2) {
        this.id2 = id2;
    }
    
}
