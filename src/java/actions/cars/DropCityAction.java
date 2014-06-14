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
public class DropCityAction extends ActionSupport {
    private Integer id;
    private Integer id2;
    
    public Integer getId2() {
        return id2;
    }
    
    public void setId2(Integer id2) {
        this.id2 = id2;
    }
    
    
    private Map<String,String> names;
    private CityDAO cityDAO;
    
    @Override
    public String execute(){
        this.cityDAO = new CityDAO();
        Map<String,String> carCities = this.cityDAO.cities_with_same_agency(id, id2);
        setNames(carCities);
        return SUCCESS;
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
    
    
    
}
