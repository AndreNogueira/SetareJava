package actions.cars;

import beans.CarForm;
import beans.CreditCard;
import businesslogic.CarReservation;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import dao.CarDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import model.Car;
import model.User;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author pjmaia
 */
@ParentPackage("interceptors")
@InterceptorRef(value = "loginStack")
@Results({
    @Result(name="success", location="/index.jsp"),
    @Result(name="error", location = "payment.jsp")
})
public class CarReservationAction extends ActionSupport implements ModelDriven<CreditCard>,SessionAware{
    
    private CreditCard card;
    private Map<String,Object> session;
    private List<String> creditCards;
    private List<String> years;
    private Map<Integer, String> months;
    private Car car;
    
    public CarReservationAction(){
        card = new CreditCard();
    }
    
    @Override
    public String execute() throws Exception{
        CarForm cf = (CarForm) this.session.get("service_params");
        User user = (User) this.session.get("user");
        if(create_reservation(user, cf, card)){
            addActionMessage("Your Car reservation was succefully created. Check your email please.");
        }else{
            addActionError("Your Credit Card is Invalid! Please check your data.");
        }
        
        load_car((int)session.get("car_id"));
        fillCreditCards();
        fillMonths();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        fillYears(year, year + 40);
        return SUCCESS;
    }
    
    
    public void load_car(int car_id){
        CarDAO cDAO = new CarDAO();
        setCar(cDAO.find(car_id));
    }
    
    
    public boolean create_reservation(User user, CarForm service_params, CreditCard card){
        boolean success = false;
        Map<String, Object> data = new TreeMap<>();
        data.put("final_price", (double)session.get("final_price"));
        data.put("car_id", (int) session.get("car_id"));
        data.put("gps_extra", (boolean) session.get("gps_extra"));
        data.put("additional_driver_extra", (boolean) session.get("additional_driver_extra"));
        data.put("baby_seat_extra", (boolean) session.get("baby_seat_extra"));
        CarReservation cr = new CarReservation(user, service_params, card, data);
        success = cr.reservation();
        return success;
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
    
    @Override
    public CreditCard getModel() {
        return card;
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
    
    public List<String> getCreditCards() {
        return creditCards;
    }
    
    public List<String> getYears() {
        return years;
    }
    
    public Map<Integer, String> getMonths() {
        return months;
    }
    public Car getCar() {
        return car;
    }
    
    public void setCar(Car car) {
        this.car = car;
    }
}
