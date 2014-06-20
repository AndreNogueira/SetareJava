/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package dao;

import java.util.Date;
import java.util.List;
import model.CarService;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author pjmaia
 */
public class CarServiceDAO extends AbstractDAO<CarService>{
    
    public List <CarService> services(int car_id){
        Criteria c = super.getSession().createCriteria(CarService.class,"car_service");
        c.add(Restrictions.eq("car.id", car_id));
        c.add(Restrictions.eq("serviceEnd", new Date()));
        List<CarService> services = c.list();
        return services;
    }
}
