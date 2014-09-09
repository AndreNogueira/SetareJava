package businesslogic;

import beans.CarForm;
import beans.CreditCard;
import beans.Mailer;
import dao.CarDAO;
import dao.CarServiceDAO;
import dao.SubsidiaryDAO;
import java.math.BigDecimal;
import java.util.Map;
import model.CarService;
import model.User;


public class CarReservation {
    
    private User user;
    private CarForm service_parms;
    private CreditCard card;
    private Map<String, Object> other_data;
    
    public CarReservation(User u, CarForm cf, CreditCard c, Map<String,Object> data){
        this.card = c;
        this.user = u;
        this.service_parms = cf;
        this.other_data = data;
        
    }
    
    private CarService car_service(){
        CarService car_service = new CarService();
        SubsidiaryDAO sDAO = new SubsidiaryDAO();
        CarDAO car = new CarDAO();
        CarServiceDAO csDAO = new CarServiceDAO();
        car_service.setServiceBegin(service_parms.getPick_date());
        car_service.setServiceEnd(service_parms.getDrop_date());
        car_service.setGps((boolean)other_data.get("gps_extra"));
        car_service.setBabySeat((boolean)other_data.get("baby_seat_extra"));
        car_service.setInsurance(false);
        car_service.setAdditionalDriver((boolean)other_data.get("additional_driver_extra"));
        car_service.setFinalPrice(BigDecimal.valueOf((double)other_data.get("final_price")));
        car_service.setCar(car.find((int)other_data.get("car_id")));
        car_service.setUser(user);
        car_service.setSubsidiaryByPickUpSubsidiaryId(sDAO.find(service_parms.getPick_subsidiary()));
        car_service.setSubsidiaryByDropOffSubsidiaryId(sDAO.find(service_parms.getDrop_subsidiary()));
        csDAO.create(car_service);
        return car_service;
    }
    
    public boolean reservation() {
        if (validateCreditCard()) {
            CarService cs = car_service();
            if (cs != null) {
                Mailer m = new Mailer();
                m.sendCarServiceMail(cs);
                return true;
            }
            return false;
        } else {
            return false;
        }
    }
    
    public boolean validateCreditCard(){
        return this.card.validateCreditCard();
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public CarForm getService_parms() {
        return service_parms;
    }
    
    public void setService_parms(CarForm service_parms) {
        this.service_parms = service_parms;
    }
    
    public CreditCard getCard() {
        return card;
    }
    
    public void setCard(CreditCard card) {
        this.card = card;
    }
    
}
