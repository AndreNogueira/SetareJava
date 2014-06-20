/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package actions.cars;

import beans.CarForm;
import beans.CarLocations;
import com.opensymphony.xwork2.ActionSupport;
import dao.CarDAO;
import java.util.Map;
import model.Car;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author pjmaia
 */
@Namespace("/cars")
public class ServiceExtrasAction extends ActionSupport implements SessionAware{
    
    private int car_id;
    private Map<String,Object> session;
    private CarLocations locations;
    private Car car;
    private double cost;
    
    
    
    
    @Override
    public String execute() throws Exception{
        this.session.put("car_id",car_id);
        CarForm cf = (CarForm)session.get("service_params");
        load_params(cf);
        load_car(car_id);
        calc_price(car_id, cf);
        this.session.put("total_price",cost);
        this.session.put("location_names", locations.getLocation_names());
        return SUCCESS;
    }
    
    public void load_params(CarForm cf){
        this.locations = new CarLocations(cf.getPick_country(),
                cf.getPick_city(),
                cf.getPick_subsidiary(),
                cf.getDrop_city());
    }
    
    public void load_car(int car_id){
        CarDAO cDAO = new CarDAO();
        setCar(cDAO.find(car_id));
    }
    
    public void calc_price(int car_id, CarForm cf){
        int days = (int)(cf.getDrop_date().getTime() - cf.getPick_date().getTime()) / (1000 * 60 * 60 * 24);
        double total =  this.car.getPrice().doubleValue() * days;
        setCost(total);
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
    public int getCar_id() {
        return car_id;
    }
    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }
    public CarLocations getLocations() {
        return locations;
    }
    public void setLocations(CarLocations locations) {
        this.locations = locations;
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
