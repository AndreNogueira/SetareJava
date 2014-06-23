/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package actions.cars;

import beans.CarForm;
import beans.CreditCard;
import businesslogic.CarReservation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Map;
import java.util.TreeMap;
import model.User;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author pjmaia
 */

@Results({
  @Result(name="success", location="/index.jsp")
})
public class CarReservationAction extends ActionSupport implements ModelDriven<CreditCard>,SessionAware{
    
    private CreditCard card;
    private Map<String,Object> session;
    
    public CarReservationAction(){
        card = new CreditCard();
    }
    
    @Override
    public String execute() throws Exception{
        CarForm cf = (CarForm) this.session.get("service_params");
        User user = (User) this.session.get("user");
        create_reservation(user, cf, card);
        addActionMessage("Your Car reservation was succefully created. Check your email please.");
        return SUCCESS;                             
    }
    
    
    public void create_reservation(User user, CarForm service_params, CreditCard card){        
        Map<String, Object> data = new TreeMap<>();
        data.put("final_price", (double)session.get("final_price"));
        data.put("car_id", (int) session.get("car_id"));
        data.put("gps_extra", (boolean) session.get("gps_extra"));
        data.put("additional_driver_extra", (boolean) session.get("additional_driver_extra"));
        data.put("baby_seat_extra", (boolean) session.get("baby_seat_extra"));
        CarReservation cr = new CarReservation(user, service_params, card, data);
    }
    

    @Override
    public CreditCard getModel() {
        return card;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
    
    
}
