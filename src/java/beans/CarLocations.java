/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package beans;

import dao.CityDAO;
import dao.CountryDAO;
import dao.SubsidiaryDAO;
import java.util.List;
import java.util.Map;
import model.Country;

/**
 *
 * @author pjmaia
 */
public class CarLocations {
    /*
    @countries = Country.with_subsidiaries
    @pick_cities = City.with_subsidiaries(pick_country)
    @pick_subs = Subsidiary.where(city_id: pick_city)
    @drop_cities = City.cities_with_same_agency(pick_country, Subsidiary.find(pick_subsidiary).agency.id)
    @drop_subs = Subsidiary.drop_subsidiaries(check_params,Subsidiary.find(pick_subsidiary).agency.id)
    */
    private List<Country> countries;
    private Map<String,String> pick_cities;
    private Map<String,String> pick_subs;
    private Map<String,String> drop_cities;
    private Map<String,String> drop_subs;
    
    //instatiate DAOs
    private CountryDAO cDAO = new CountryDAO();
    private CityDAO ciDAO = new CityDAO();
    private SubsidiaryDAO sDAO = new SubsidiaryDAO();
    
    public CarLocations(int pick_country_id, int pick_city_id, int pick_subsidiary_id,int drop_city_id) {
        this.countries =  cDAO.countries_with_subs();
        this.drop_cities = ciDAO.cities_with_same_agency(pick_country_id, sDAO.find(pick_subsidiary_id).getAgency().getId());
        this.pick_cities = ciDAO.cities_with_subsidiaries(pick_country_id);
        this.pick_subs = sDAO.pick_subsidiaries(pick_city_id);        
        this.drop_subs = sDAO.drop_subsidiaries(drop_city_id, sDAO.find(pick_subsidiary_id).getAgency().getId());
    }
    
    public List<Country> getCountries() {
        return countries;
    }
    
    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
    
    public Map<String, String> getPick_cities() {
        return pick_cities;
    }
    
    public void setPick_cities(Map<String, String> pick_cities) {
        this.pick_cities = pick_cities;
    }
    
    public Map<String, String> getPick_subs() {
        return pick_subs;
    }
    
    public void setPick_subs(Map<String, String> pick_subs) {
        this.pick_subs = pick_subs;
    }
    
    public Map<String, String> getDrop_cities() {
        return drop_cities;
    }
    
    public void setDrop_cities(Map<String, String> drop_cities) {
        this.drop_cities = drop_cities;
    }
    
    public Map<String, String> getDrop_subs() {
        return drop_subs;
    }
    
    public void setDrop_subs(Map<String, String> drop_subs) {
        this.drop_subs = drop_subs;
    }
}
