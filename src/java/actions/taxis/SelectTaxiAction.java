package actions.taxis;

import beans.TaxiForm;
import beans.TaxiLocations;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.interceptor.SessionAware;

@Namespace("/taxis")
public class SelectTaxiAction extends ActionSupport implements SessionAware {

    private Integer idTaxi;
    private double cost;
    private Map<String, Object> session;
    private TaxiLocations taxiLocations;
    private List<String> creditCards;
    private Map<Integer, String> months;
    private List<String> years;

    public SelectTaxiAction() {
    }

    @Override
    public String execute() throws Exception {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        TaxiForm taxiFormSearch = (TaxiForm) session.get("taxiForm");
        this.taxiLocations = new TaxiLocations(taxiFormSearch.getCountry(), taxiFormSearch.getCity(), taxiFormSearch.getPickUpLocation());
        fillCreditCards();
        fillMonths();
        fillYears(year, year + 40);
        return SUCCESS;
    }

    private void fillCreditCards() {
        this.creditCards = new ArrayList<>();
        this.creditCards.add("Visa");
        this.creditCards.add("MasterCard");
        this.creditCards.add("Discover");
        this.creditCards.add("Amex");
        this.creditCards.add("Diner\'s Club");
    }

    private void fillYears(int year, int max) {
        this.years = new ArrayList<>();
        for (int i = year; i <= max; i++) {
            this.years.add(Integer.toString(i));
        }
    }

    private void fillMonths() {
        this.months = new TreeMap<>();
        this.months.put(1, "1 - Jan");
        this.months.put(2, "2 - Feb");
        this.months.put(3, "3 - Mar");
        this.months.put(4, "4 - Apr");
        this.months.put(5, "5 - May");
        this.months.put(6, "6 - Jun");
        this.months.put(7, "7 - Jul");
        this.months.put(8, "8 - Aug");
        this.months.put(9, "9 - Sept");
        this.months.put(10, "10 - Oct");
        this.months.put(11, "11 - Nov");
        this.months.put(12, "12 - Dec");
    }

    /* Getters and Setters */
    public Integer getIdTaxi() {
        return idTaxi;
    }

    public double getCost() {
        return cost;
    }

    public TaxiLocations getTaxiLocations() {
        return taxiLocations;
    }

    public List<String> getCreditCards() {
        return creditCards;
    }

    public Map<Integer, String> getMonths() {
        return months;
    }

    public List<String> getYears() {
        return years;
    }

    public void setIdTaxi(Integer idTaxi) {
        this.idTaxi = idTaxi;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

}
