package beans;

import dao.CityDAO;
import dao.CountryDAO;
import dao.DropOffLocationDAO;
import dao.PickUpLocationDAO;
import java.util.Map;

public class TaxiLocations {
    private Map<String,String> countries;
    private Map<String,String> cities;
    private Map<String,String> pickUpLocations;
    private Map<String,String> dropOffLocations;
    
    private final CountryDAO countryDAO;
    private final CityDAO cityDAO;
    private final PickUpLocationDAO pickUpDAO;
    private final DropOffLocationDAO dropOffDAO;
    
    public TaxiLocations(Integer idCountry, Integer idCity, Integer idPickUp){
        this.countryDAO = new CountryDAO();
        this.cityDAO = new CityDAO();
        this.pickUpDAO = new PickUpLocationDAO();
        this.dropOffDAO = new DropOffLocationDAO();
        
        this.countries = this.countryDAO.taxis();
        this.cities = this.cityDAO.taxis(idCountry);
        this.pickUpLocations = this.pickUpDAO.getPickUpLocationsByCity(idCity);
        this.dropOffLocations = this.dropOffDAO.getDropOffLocationsByIdPickUp(idPickUp);        
    }
    
    /* Getters and Setters */
    public Map<String, String> getCountries() {
        return countries;
    }

    public Map<String, String> getCities() {
        return cities;
    }

    public Map<String, String> getPickUpLocations() {
        return pickUpLocations;
    }

    public Map<String, String> getDropOffLocations() {
        return dropOffLocations;
    }

    public void setCountries(Map<String, String> countries) {
        this.countries = countries;
    }

    public void setCities(Map<String, String> cities) {
        this.cities = cities;
    }

    public void setPickUpLocations(Map<String, String> pickUpLocations) {
        this.pickUpLocations = pickUpLocations;
    }

    public void setDropOffLocations(Map<String, String> dropOffLocations) {
        this.dropOffLocations = dropOffLocations;
    }
    
    
    
}
