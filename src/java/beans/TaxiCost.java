package beans;

import model.Taxi;

public class TaxiCost {
    
    private Taxi taxi;
    private double cost;
    
    public TaxiCost(Taxi taxi, double cost){
        this.taxi = taxi;
        this.cost = cost;
    }

    public Taxi getTaxi() {
        return taxi;
    }

    public double getCost() {
        return cost;
    }

    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }   
    
}
