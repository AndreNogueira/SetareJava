/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package beans;

import dao.CarDAO;
import dao.SubsidiaryDAO;
import java.util.Date;
import java.util.List;
import java.util.Map;
import model.Car;

/**
 *
 * @author pjmaia
 */
public class CarSearch {
    private List<Car> list_selected_subsidiary;
    private Map <Integer,List<Car>> other_agencies_list;    
    
    private SubsidiaryDAO sDAO;
    private CarDAO cDAO;    
    
    public CarSearch (int pick_subsidiary_id, Date pick_date, Date drop_date, int pick_city, int drop_city ){
        this.list_selected_subsidiary = cDAO.car_list(pick_subsidiary_id);
        this.other_agencies_list = other_cars_list(pick_city, drop_city, pick_subsidiary_id, pick_date, drop_date);
    }
    
    public Map <Integer,List<Car>> other_cars_list(int pick_city_id, int drop_city_id, int pick_subsidiary_id, Date pick_date, Date drop_date){
        
        Map<Integer,List<Car>> other_agencies_list = null;
        int [] list = sDAO.other_subsidiaries(pick_city_id, drop_city_id, pick_subsidiary_id);
        for(int l=0; l<list.length;l++){
            other_agencies_list.put( l,cDAO.check_available_cars(list[l], pick_date, drop_date));
        }
        return other_agencies_list;
    }
    
    public List<Car> getList_selected_subsidiary() {
        return list_selected_subsidiary;
    }
    
    public Map<Integer, List<Car>> getOther_agencies_list() {
        return other_agencies_list;
    }
        
}
