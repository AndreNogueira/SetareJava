package businesslogic;

import beans.Mailer;
import beans.TaxiForm;
import beans.TaxiReservationForm;
import dao.CityDAO;
import dao.CountryDAO;
import dao.DropOffLocationDAO;
import dao.PickUpLocationDAO;
import dao.TaxiDAO;
import dao.TaxiServiceDAO;
import dao.UserDAO;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Taxi;
import model.TaxiService;
import model.User;

public class TaxiReservation {

    private TaxiReservationForm taxiReservation;
    private TaxiForm taxiForm;
    private User user;

    public TaxiReservation(TaxiReservationForm trf, TaxiForm tf, User userNow) {
        this.taxiReservation = trf;
        this.taxiForm = tf;
        this.user = userNow;
    }

    public boolean reservation() {
        if (this.taxiReservation.validateCreditCard()) {
            updateUser();
            TaxiService tss = createTaxiService();
            if (tss != null) {
                //Mailer m = new Mailer();
                //m.sendTaxiServiceMail(tss);
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    private void updateUser() {
        if (!this.taxiReservation.getUser().equals(this.user)) {
            User user1 = this.taxiReservation.getUser();
            UserDAO userDao = new UserDAO();
            this.user.setAddress(user1.getAddress());
            this.user.setBi(user1.getBi());
            this.user.setDriverLicense(user1.getDriverLicense());
            this.user.setEmail(user1.getEmail());
            this.user.setName(user1.getName());
            this.user.setNif(user1.getNif());
            this.user.setPhoneNumber(user1.getPhoneNumber());
            boolean res = userDao.update(this.user);
        }
    }

    private TaxiService createTaxiService() {
        TaxiServiceDAO taxiServiceDAO = new TaxiServiceDAO();
        TaxiService ts = new TaxiService();
        ts.setFinalPrice(new BigDecimal(this.taxiReservation.getCost()));
        ts.setTaxi(getTaxi());
        ts.setUser(this.user);
        ts.setLuggage(getLuggageValue());
        ts.setSpecialRequest(this.taxiReservation.getSpecialRequest());
        ts.setCountry(getCountry());
        ts.setCity(getCity());
        ts.setPickUpLocation(getPickUpLocation());
        ts.setDropOffLocation(getDropOffLocation());
        ts.setRoundTrip(getRoundTrip());
        ts.setServiceBegin(getServiceBegin());
        ts.setServiceEnd(getServiceEnd());
        taxiServiceDAO.create(ts);
        return ts;
    }

    private boolean getLuggageValue() {
        return this.taxiReservation.getLuggage().equals("Yes");
    }

    private Taxi getTaxi() {
        TaxiDAO taxiDAO = new TaxiDAO();
        return taxiDAO.find(this.taxiReservation.getIdTaxi());
    }

    private String getCountry() {
        CountryDAO countryDAO = new CountryDAO();
        return countryDAO.find(this.taxiForm.getCountry()).getName();
    }

    private String getCity() {
        CityDAO cityDao = new CityDAO();
        return cityDao.find(this.taxiForm.getCity()).getName();
    }

    private String getPickUpLocation() {
        PickUpLocationDAO pickUp = new PickUpLocationDAO();
        return pickUp.find(this.taxiForm.getPickUpLocation()).getName();
    }

    private String getDropOffLocation() {
        DropOffLocationDAO dropOffs = new DropOffLocationDAO();
        return dropOffs.find(this.taxiForm.getDropOffLocation()).getName();
    }

    private boolean getRoundTrip() {
        return this.taxiForm.getType_trip().equals("Round Trip");
    }

    private Date getServiceBegin() {
        String date = this.taxiForm.getBegin_date() + " " + this.taxiForm.getBegin_time();
        Date dat = null;
        try {
            dat = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(date);
        } catch (ParseException ex) {
        }
        return dat;
    }

    private Date getServiceEnd() {
        String date = this.taxiForm.getEnd_date() + " " + this.taxiForm.getEnd_time();
        Date dat = null;
        try {
            dat = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(date);
        } catch (ParseException ex) {
        }
        return dat;
    }
}
