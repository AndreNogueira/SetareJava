/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package beans;

import java.util.Date;
import java.util.List;
import model.Car;

/**
 *
 * @author pjmaia
 */
public class CarSearch {
    private List<Car> list_selected_subsidiary;
    private List<Car> other_agencies_list;
    
    
    public CarSearch (int pick_subsidiary_id, Date pick_date, Date drop_date, int pick_city, int drop_city ){
        
    }
    
    /*
    private
    def remaining_subsidiaries
    Subsidiary.other_subsidiaries(pick_city,drop_city,pick_subsidiary)
    end
    
    def other_cars_list
    #list of all Available cars in others subsidiaries from the same cities
    other_agencies_list = []
    remaining_subsidiaries.each do |f|
    other_agencies_list << Car.check_available_cars(f,begin_date,end_date)
    end
    other_agencies_list
    end
    
    def cars_list
    Car.check_available_cars(pick_subsidiary,begin_date,end_date)
    end
    */
    public void other_cars_list(){
        //list of all Available cars in others subsidiaries from the same cities
       //other_agencies_list = []
    //remaining_subsidiaries.each do |f|
    //other_agencies_list << Car.check_available_cars(f,begin_date,end_date)
    //end
    //other_agencies_list
    }
    
    public List<Car> getList_selected_subsidiary() {
        return list_selected_subsidiary;
    }
    
    public List<Car> getOther_agencies_list() {
        return other_agencies_list;
    }   
}
