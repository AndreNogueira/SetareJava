package model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="taxi_service"
    ,catalog="Setare"
)
public class TaxiService  implements java.io.Serializable {


     private Integer id;
     private Taxi taxi;
     private User user;
     private Date serviceBegin;
     private Date serviceEnd;
     private boolean roundTrip;
     private boolean luggage;
     private BigDecimal finalPrice;
     private String specialRequest;
     private String country;
     private String city;
     private String pickUpLocation;
     private String dropOffLocation;

    public TaxiService() {
    }

	
    public TaxiService(Taxi taxi, User user, Date serviceBegin, boolean roundTrip, boolean luggage, BigDecimal finalPrice, String country, String city, String pickUpLocation, String dropOffLocation) {
        this.taxi = taxi;
        this.user = user;
        this.serviceBegin = serviceBegin;
        this.roundTrip = roundTrip;
        this.luggage = luggage;
        this.finalPrice = finalPrice;
        this.country = country;
        this.city = city;
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
    }
    public TaxiService(Taxi taxi, User user, Date serviceBegin, Date serviceEnd, boolean roundTrip, boolean luggage, BigDecimal finalPrice, String specialRequest, String country, String city, String pickUpLocation, String dropOffLocation) {
       this.taxi = taxi;
       this.user = user;
       this.serviceBegin = serviceBegin;
       this.serviceEnd = serviceEnd;
       this.roundTrip = roundTrip;
       this.luggage = luggage;
       this.finalPrice = finalPrice;
       this.specialRequest = specialRequest;
       this.country = country;
       this.city = city;
       this.pickUpLocation = pickUpLocation;
       this.dropOffLocation = dropOffLocation;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="taxi_id", nullable=false)
    public Taxi getTaxi() {
        return this.taxi;
    }
    
    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="service_begin", nullable=false, length=19)
    public Date getServiceBegin() {
        return this.serviceBegin;
    }
    
    public void setServiceBegin(Date serviceBegin) {
        this.serviceBegin = serviceBegin;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="service_end", length=19)
    public Date getServiceEnd() {
        return this.serviceEnd;
    }
    
    public void setServiceEnd(Date serviceEnd) {
        this.serviceEnd = serviceEnd;
    }

    
    @Column(name="round_trip", nullable=false)
    public boolean isRoundTrip() {
        return this.roundTrip;
    }
    
    public void setRoundTrip(boolean roundTrip) {
        this.roundTrip = roundTrip;
    }

    
    @Column(name="luggage", nullable=false)
    public boolean isLuggage() {
        return this.luggage;
    }
    
    public void setLuggage(boolean luggage) {
        this.luggage = luggage;
    }

    
    @Column(name="final_price", nullable=false, precision=10)
    public BigDecimal getFinalPrice() {
        return this.finalPrice;
    }
    
    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    
    @Column(name="special_request", length=300)
    public String getSpecialRequest() {
        return this.specialRequest;
    }
    
    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }

    
    @Column(name="country", nullable=false)
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }

    
    @Column(name="city", nullable=false)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    
    @Column(name="pick_up_location", nullable=false)
    public String getPickUpLocation() {
        return this.pickUpLocation;
    }
    
    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    
    @Column(name="drop_off_location", nullable=false)
    public String getDropOffLocation() {
        return this.dropOffLocation;
    }
    
    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }




}


