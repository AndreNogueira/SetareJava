package actions.taxis;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Namespace;

@Namespace("/taxis")
public class SelectTaxiAction extends ActionSupport {
    
    private Integer idTaxi;
    private double cost;
    
    public SelectTaxiAction() {
    }
    
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    /* Getters and Setters */
    public Integer getIdTaxi() {
        return idTaxi;
    }

    public double getCost() {
        return cost;
    }

    public void setIdTaxi(Integer idTaxi) {
        this.idTaxi = idTaxi;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    
    
}
