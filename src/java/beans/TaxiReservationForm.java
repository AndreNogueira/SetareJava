package beans;

import model.User;

public class TaxiReservationForm {

    private User user;
    private Integer idTaxi;
    private double cost;
    private String luggage;
    private String specialRequest;
    private CreditCard creditCard;

    /* Getters and Setters */
    public User getUser() {
        return user;
    }

    public String getLuggage() {
        return luggage;
    }

    public String getSpecialRequest() {
        return specialRequest;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public Integer getIdTaxi() {
        return idTaxi;
    }

    public double getCost() {
        return cost;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLuggage(String luggage) {
        this.luggage = luggage;
    }

    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public void setIdTaxi(Integer idTaxi) {
        this.idTaxi = idTaxi;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
