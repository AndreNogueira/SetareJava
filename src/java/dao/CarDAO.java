/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package dao;

import java.util.Date;
import java.util.List;
import model.Car;
import model.Subsidiary;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author pjmaia
 */
public class CarDAO extends AbstractDAO<Car>{
    /*
    def self.check_available_cars current_subsidiary, pick_date, drop_date
    pdate = Date.parse(pick_date)
    ddate = Date.parse(drop_date)
    now = Date.current
    car_list = Car.current_subsidiary(current_subsidiary)
    car_list.each_with_index do |c,i|
    services = CarService.services(c)
    services.each do |s|
    unless((pdate >= now && ddate > now) && ((pdate > s.service_end && ddate > s.service_end) ||
    (pdate < s.service_begin && ddate < s.service_begin-1.day)))
    car_list.delete_at(i)
    end
    end
    end
    car_list
    end
    */
    
    public void check_available_cars(int current_subsidiary, Date pick_date, Date drop_date){
        Date now = new Date();
        List<Car> car_list = car_list(current_subsidiary);
        for(Car c : car_list){
        
        }
        
    }
    
    private List<Car> car_list(int current_subsidiary){
        Criteria c = super.getSession().createCriteria(Car.class,"car");
        c.add(Restrictions.eq("current_subsidiary", current_subsidiary));
        c.add(Restrictions.eq("is_available", true));
        List<Car> list = c.list();
        return list;
    }
}
