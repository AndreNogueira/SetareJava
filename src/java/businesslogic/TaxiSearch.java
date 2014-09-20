package businesslogic;

import beans.TaxiCost;
import beans.TaxiCostComparator;
import dao.DropOffLocationDAO;
import dao.PickUpLocationDAO;
import dao.TaxiDAO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import model.Taxi;

public class TaxiSearch {

    private Integer idPickUp;
    private Integer idDropOff;
    private Integer passengers;
    private String roundTrip;

    public TaxiSearch(Integer idPickUp, Integer idDropOff, Integer passengers, String roundTrip) {
        this.idPickUp = idPickUp;
        this.idDropOff = idDropOff;
        this.passengers = passengers;
        this.roundTrip = roundTrip;
    }

    public Set<TaxiCost> search() {
        TaxiDAO taxisDAO = new TaxiDAO();
        double distance = calculateDistanceInKm(getPickUpLocationName(), getDropOffLocationName());
        List<Taxi> taxis = taxisDAO.searchTaxisWithPassengers(idPickUp, passengers);
        return taxisPrices(taxis, distance);
    }

    private Set<TaxiCost> taxisPrices(List<Taxi> listTaxis, double distance) {
        Set<TaxiCost> results = new TreeSet<>(new TaxiCostComparator());
        for (Taxi t : listTaxis) {
            results.add(new TaxiCost(t, t.getPriceKm().doubleValue() * distance));
        }
        return results;
    }

    private double calculateDistanceInKm(String pickUpName, String dropOffName) {
        //double dist = DistanceCalculator.calculateDistance(pickUpName, dropOffName);
        //if(dist == 0) dist = 20.0;
        Random r = new Random();
        double d = 25.0 + r.nextDouble() * 200.0;
        BigDecimal bd = new BigDecimal(d);
        BigDecimal aux = bd.setScale(2, RoundingMode.HALF_UP);
        return checkDistanceRoundTrip(aux.doubleValue());
    }

    private double checkDistanceRoundTrip(double distance) {
        return isRoundTrip() ? distance * 2 : distance;
    }

    private boolean isRoundTrip() {
        return this.roundTrip.equals("Round Trip");
    }

    private String getPickUpLocationName() {
        PickUpLocationDAO p = new PickUpLocationDAO();
        return p.find(this.idPickUp).getName();
    }

    private String getDropOffLocationName() {
        DropOffLocationDAO d = new DropOffLocationDAO();
        return d.find(this.idDropOff).getName();
    }

    /* Getters and Setters */
    public Integer getIdPickUp() {
        return idPickUp;
    }

    public Integer getIdDropOff() {
        return idDropOff;
    }

    public Integer getPassengers() {
        return passengers;
    }

    public String getRoundTrip() {
        return roundTrip;
    }

    public void setIdPickUp(Integer idPickUp) {
        this.idPickUp = idPickUp;
    }

    public void setIdDropOff(Integer idDropOff) {
        this.idDropOff = idDropOff;
    }

    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }

    public void setRoundTrip(String roundTrip) {
        this.roundTrip = roundTrip;
    }
}
