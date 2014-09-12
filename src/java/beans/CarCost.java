package beans;

import model.Car;

public class CarCost {
    
    private Car car;
    private double cost;
    
    public CarCost(Car car, double cost) {
        this.car = car;
        this.cost = cost;
    }
    
    public Car getCar() {
        return car;
    }
    
    public void setCar(Car car) {
        this.car = car;
    }
    
    public double getCost() {
        return cost;
    }
    
    public void setCost(double cost) {
        this.cost = cost;
    }
}
