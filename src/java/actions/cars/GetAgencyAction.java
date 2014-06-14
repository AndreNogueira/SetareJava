/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package actions.cars;

import com.opensymphony.xwork2.ActionSupport;
import dao.AgencyDAO;
import model.Agency;
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
public class GetAgencyAction extends ActionSupport{
    
    private Integer id;
    private Integer id_agency;
    
    @Override
    public String execute(){
        AgencyDAO aDAO = new AgencyDAO();
        Agency x = new Agency();
        x = aDAO.getAgency(id);        
        setId_agency(x.getId());
        return SUCCESS;
    }
    
    public Integer getId_agency() {
        return id_agency;
    }
    
    public void setId_agency(Integer id_agency) {
        this.id_agency = id_agency;
    }    
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
}
