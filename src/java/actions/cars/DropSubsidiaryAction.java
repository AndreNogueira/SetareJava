/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package actions.cars;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dao.SubsidiaryDAO;
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
public class DropSubsidiaryAction extends ActionSupport{
    
    private Integer id;
    private Integer id2;
    private Map<String,String> names;
    
    @Override
    public String execute() throws Exception{
        load_drop_subsidiaries(id,id2);
        return SUCCESS;
    }
    
    public void load_drop_subsidiaries(int drop_city_id,int agency_id){
        SubsidiaryDAO subsidiaryDAO = new SubsidiaryDAO();
        Map<String,String> carSubsidiaries = subsidiaryDAO.drop_subsidiaries(drop_city_id, agency_id);
        setNames(carSubsidiaries);
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
    
    public void setId2(Integer id2) {
        this.id2 = id2;
    }
}
