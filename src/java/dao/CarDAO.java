package dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.Car;
import model.CarService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import utils.GenericDAO;

public class CarDAO extends GenericDAO<Car> {

    @SuppressWarnings("unchecked")
    public List<Car> check_available_cars(int current_subsidiary, Date pick_date, Date drop_date) {
        Date now = new Date();
        CarServiceDAO CSDAO = new CarServiceDAO();

        Calendar calendarData = Calendar.getInstance();
        calendarData.setTime(now);
        calendarData.add(Calendar.DATE, -1);
        Date day_before_now = calendarData.getTime();

        List<Car> car_list = car_list(current_subsidiary);
        for (Car c : car_list) {
            List<CarService> services = CSDAO.services(c.getId());
            for (CarService cs : services) {
                if (!((pick_date.after(now) && drop_date.after(now))
                        && (pick_date.after(cs.getServiceEnd()) && drop_date.after(cs.getServiceEnd()))
                        || (pick_date.before(cs.getServiceBegin()) && drop_date.before(day_before_now)))) {
                    car_list.remove(c);
                }
            }
        }
        return car_list;
    }

    @SuppressWarnings("unchecked")
    public List<Car> car_list(int current_subsidiary) {
        List<Car> listRes = null;
        Session session = getSession();
        session.beginTransaction();
        try {
            listRes = session.createCriteria(Car.class, "car")
                    .createAlias("car.agency", "agency")
                    .createAlias("car.category", "category")
                    .add(Restrictions.eq("currentSubsidiary", current_subsidiary))
                    .add(Restrictions.eq("isAvailable", true))
                    .list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return listRes;
    }
    
    public Car find(int car_id){
        Car res = null;
        Session session = getSession();
        session.beginTransaction();
        try {
            res = (Car) session.createCriteria(Car.class,"car")
                        .createAlias("car.agency", "agency")
                        .createAlias("car.category", "category")
                        .add(Restrictions.eq("id", car_id))
                        .uniqueResult();                    
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return res;
    }
}
