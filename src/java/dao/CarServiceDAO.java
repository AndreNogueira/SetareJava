package dao;

import java.util.Date;
import java.util.List;
import model.CarService;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class CarServiceDAO extends AbstractDAO<CarService>{
    
    public List <CarService> services(int car_id){
        Criteria c = super.getSession().createCriteria(CarService.class,"car_service");
        c.add(Restrictions.eq("car.id", car_id));
        c.add(Restrictions.eq("service_end", new Date()));
        List<CarService> services = c.list();
        return services;
    }
    
    public List<CarService> getCarServicesFromUser(Integer idUser){
        Criteria crit = super.getSession().createCriteria(CarService.class, "carService");
        crit.add(Restrictions.eq("user.id", idUser));
        return crit.list();       
    }
}
