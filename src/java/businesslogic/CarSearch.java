package businesslogic;

import beans.CarCost;
import beans.CarCostComparator;
import dao.CarDAO;
import dao.SubsidiaryDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import model.Car;


public class CarSearch {

    private Set<CarCost> list_selected_subsidiary;
    private Map<Integer, Set<CarCost>> other_agencies_list;

    private SubsidiaryDAO sDAO;
    private CarDAO cDAO;

    public CarSearch(int pick_subsidiary_id, Date pick_date, Date drop_date, int pick_city, int drop_city) {
        this.sDAO = new SubsidiaryDAO();
        this.cDAO = new CarDAO();
        this.list_selected_subsidiary = results(cDAO.car_list(pick_subsidiary_id), pick_date, drop_date);
        this.other_agencies_list = other_cars_list(pick_city, drop_city, pick_subsidiary_id, pick_date, drop_date);
    }

    public Set<CarCost> results(List<Car> cars_list, Date begin, Date end) {
        int days = daysBetween(begin, end);
        Set<CarCost> results = new TreeSet<>(new CarCostComparator());
        for (Car c : cars_list) {
            results.add(new CarCost(c, c.getPrice().doubleValue() * days));
        }
        return results;
    }

    private int daysBetween(Date d1, Date d2) {
        return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    public Map<Integer, Set<CarCost>> other_cars_list(int pick_city_id, int drop_city_id, int pick_subsidiary_id, Date pick_date, Date drop_date) {
        this.sDAO = new SubsidiaryDAO();
        this.cDAO = new CarDAO();
        
        Map<Integer, Set<CarCost>> other_agencies_list = new TreeMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        list = sDAO.other_subsidiaries(pick_city_id, drop_city_id, pick_subsidiary_id);
        if (list.size() > 0) {
            for (int l = 0; l < list.size(); l++) {
                other_agencies_list.put(l, results(cDAO.check_available_cars(list.get(l), pick_date, drop_date), pick_date, drop_date));
            }
        }
        return other_agencies_list;
    }

    public Set<CarCost> getList_selected_subsidiary() {
        return list_selected_subsidiary;
    }

    public Map<Integer, Set<CarCost>> getOther_agencies_list() {
        return other_agencies_list;
    }
}
