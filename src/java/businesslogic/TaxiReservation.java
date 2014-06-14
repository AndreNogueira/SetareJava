package businesslogic;

import dao.TaxiDAO;
import dao.TaxiServiceDAO;
import model.Taxi;
import model.TaxiService;
import model.User;

public class TaxiReservation {
    
    private Integer idTaxi;
    private double cost;
    private User user;
    
    private TaxiServiceDAO taxiServiceDAO;
    
    
    public TaxiReservation(Integer idTaxi, double cost, User user){
        this.idTaxi = idTaxi;
        this.cost = cost;
        this.user = user;
    }
    
    public boolean reservation(){
        return true;
    }
    
    private boolean createTaxiService(){
        TaxiService ts = new TaxiService();
        ts.setUser(this.user);
        ts.setTaxi(getTaxi());
        ts.setCity(null);
        return true;
    }
    
    private Taxi getTaxi(){
        TaxiDAO taxiDAO  = new TaxiDAO();
        return taxiDAO.find(idTaxi);
    }
}
