package beans;

public class TaxiForm {

    private Integer country;
    private Integer city;
    private Integer pickUpLocation;
    private Integer dropOffLocation;
    private Integer passengers;
    private String type_trip;
    private String begin_date;
    private String begin_time;
    private String end_date;
    private String end_time;

    /* Getters and Setters */
    public Integer getCountry() {
        return country;
    }

    public Integer getCity() {
        return city;
    }

    public Integer getPickUpLocation() {
        return pickUpLocation;
    }

    public Integer getDropOffLocation() {
        return dropOffLocation;
    }

    public Integer getPassengers() {
        return passengers;
    }

    public String getType_trip() {
        return type_trip;
    }

    public String getBegin_date() {
        return begin_date;
    }

    public String getBegin_time() {
        return begin_time;
    }

    public String getEnd_date() {
        return end_date;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public void setPickUpLocation(Integer pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public void setDropOffLocation(Integer dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }

    public void setType_trip(String type_trip) {
        this.type_trip = type_trip;
    }

    public void setBegin_date(String begin_date) {
        this.begin_date = begin_date;
    }

    public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

}
