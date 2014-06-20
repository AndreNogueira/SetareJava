/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package actions.cars;

import beans.CarExtras;
import beans.CarForm;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import dao.CarDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import model.Car;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author pjmaia
 */
@Namespace("/cars")
public class PaymentAction extends ActionSupport implements ModelDriven<CarExtras>,SessionAware{
    
    private CarExtras cExtras;
    private Map<String,Object> session ;
    private Car car;
    private List<String> creditCards;
    private List<String> years;
    private Map<Integer, String> months;
    //
    
    public PaymentAction() {
        this.cExtras = new CarExtras();
    }
    
    @Override
    public String execute() throws Exception{
        int year = Calendar.getInstance().get(Calendar.YEAR);
        CarForm cf = (CarForm) this.session.get("service_params");
        int car_id = (int)this.session.get("car_id");
        double car_price = (double)this.session.get("total_price");
        double final_price = car_price + extras_price(this.cExtras);
        
        this.session.put("final_price", final_price);
        this.session.put("extras", check_extras(final_price));
        this.session.put("extras_price", extras_price(this.cExtras));
        
        load_car(car_id);
        fillCreditCards();
        fillMonths();
        fillYears(year, year + 40);
        return SUCCESS;
    }
    
    
    public void load_car(int car_id){
        CarDAO cDAO = new CarDAO();
        setCar(cDAO.find(car_id));
    }
    
    private void fillCreditCards() {
        this.creditCards = new ArrayList<>();
        this.creditCards.add("Visa");
        this.creditCards.add("MasterCard");
        this.creditCards.add("Discover");
        this.creditCards.add("Amex");
        this.creditCards.add("Diner\'s Club");
    }
    
    private void fillYears(int year, int max) {
        this.years = new ArrayList<>();
        for (int i = year; i <= max; i++) {
            this.years.add(Integer.toString(i));
        }
    }
    
    private void fillMonths() {
        this.months = new TreeMap<>();
        this.months.put(1, "1 - Jan");
        this.months.put(2, "2 - Feb");
        this.months.put(3, "3 - Mar");
        this.months.put(4, "4 - Apr");
        this.months.put(5, "5 - May");
        this.months.put(6, "6 - Jun");
        this.months.put(7, "7 - Jul");
        this.months.put(8, "8 - Aug");
        this.months.put(9, "9 - Sept");
        this.months.put(10, "10 - Oct");
        this.months.put(11, "11 - Nov");
        this.months.put(12, "12 - Dec");
    }
    
    public void set_prices(CarExtras ce){
        
    }
    
    private boolean check_extras(double extras_price){
        if(extras_price != 0){
            return true;
        }else{
            return false;
        }
    }
    
    public double extras_price(CarExtras ce){
        double extras_price = 0;
        if (ce.getAdditional_driver_quantity() > 0){
            extras_price+= 6.15 * ce.getAdditional_driver_quantity();
        }
        if(ce.getGps_quantity() > 0){
            extras_price+= 8.61 * ce.getGps_quantity();
        }
        if(ce.getBaby_seat_quantity() > 0){
            extras_price+= 10.46 * ce.getBaby_seat_quantity();
        }
        return extras_price;
    }
    
    
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
    
    @Override
    public CarExtras getModel() {
        return cExtras;
    }
    
    public Map<Integer, String> getMonths() {
        return months;
    }
    
    public CarExtras getcExtras() {
        return cExtras;
    }
    
    public void setcExtras(CarExtras cExtras) {
        this.cExtras = cExtras;
    }
    public Car getCar() {
        return car;
    }
    
    public void setCar(Car car) {
        this.car = car;
    }
    public List<String> getYears() {
        return years;
    }
    public List<String> getCreditCards() {
        return creditCards;
    }
}
