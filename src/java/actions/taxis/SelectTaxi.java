package actions.taxis;

import com.opensymphony.xwork2.ActionSupport;

public class SelectTaxi extends ActionSupport {
    
    private Integer idTaxi;
    private double cost;
    
    public SelectTaxi() {
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
