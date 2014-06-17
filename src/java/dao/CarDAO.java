/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.Car;
import model.CarService;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author pjmaia
 */
public class CarDAO extends AbstractDAO<Car>{

    
    public List<Car> check_available_cars(int current_subsidiary, Date pick_date, Date drop_date){
        Date now = new Date();
        CarServiceDAO CSDAO = new CarServiceDAO();
       
        Calendar calendarData = Calendar.getInstance();
        calendarData.setTime(now);    
        calendarData.add(Calendar.DATE,-1);
        Date day_before_now = calendarData.getTime();       
                
        List<Car> car_list = car_list(current_subsidiary);
        for(Car c : car_list){
            List<CarService> services = CSDAO.services(c.getId());
            for(CarService cs : services){
                if(!((pick_date.after(now) && drop_date.after(now)) &&
                    (pick_date.after(cs.getServiceEnd()) && drop_date.after(cs.getServiceEnd())) ||
                    (pick_date.before(cs.getServiceBegin()) && drop_date.before(day_before_now)))){                    
                    car_list.remove(c); 
                }
            }
        }        
        return car_list;        
    }
    
    public List<Car> car_list(int current_subsidiary){
        Criteria c = super.getSession().createCriteria(Car.class,"car");
        c.add(Restrictions.eq("currentSubsidiary", current_subsidiary));
        c.add(Restrictions.eq("isAvailable", true));
        List<Car> list = c.list();
        return list;
    }
}
