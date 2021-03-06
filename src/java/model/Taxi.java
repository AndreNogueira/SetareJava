package model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "taxi", catalog = "Setare"
)
public class Taxi implements java.io.Serializable {

    private Integer id;
    private String name;
    private String image;
    private int passengersNumber;
    private int luggage;
    private BigDecimal priceKm;
    private Set<TaxiService> taxiServices = new HashSet<>(0);
    private Set<PickUpLocationTaxi> pickUpLocationTaxis = new HashSet<>(0);
    private Set<PickUpLocation> pickUpLocations = new HashSet<>(0);

    public Taxi() {
    }

    public Taxi(String name, String image, int passengersNumber, int luggage, BigDecimal priceKm) {
        this.name = name;
        this.image = image;
        this.passengersNumber = passengersNumber;
        this.luggage = luggage;
        this.priceKm = priceKm;
    }

    public Taxi(String name, String image, int passengersNumber, int luggage, BigDecimal priceKm, Set<TaxiService> taxiServices, Set<PickUpLocationTaxi> pickUpLocationTaxis) {
        this.name = name;
        this.image = image;
        this.passengersNumber = passengersNumber;
        this.luggage = luggage;
        this.priceKm = priceKm;
        this.taxiServices = taxiServices;
        this.pickUpLocationTaxis = pickUpLocationTaxis;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "image", nullable = false)
    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "passengers_number", nullable = false)
    public int getPassengersNumber() {
        return this.passengersNumber;
    }

    public void setPassengersNumber(int passengersNumber) {
        this.passengersNumber = passengersNumber;
    }

    @Column(name = "luggage", nullable = false)
    public int getLuggage() {
        return this.luggage;
    }

    public void setLuggage(int luggage) {
        this.luggage = luggage;
    }

    @Column(name = "price_km", nullable = false, precision = 10)
    public BigDecimal getPriceKm() {
        return this.priceKm;
    }

    public void setPriceKm(BigDecimal priceKm) {
        this.priceKm = priceKm;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "taxi")
    public Set<TaxiService> getTaxiServices() {
        return this.taxiServices;
    }

    public void setTaxiServices(Set<TaxiService> taxiServices) {
        this.taxiServices = taxiServices;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "taxi")
    public Set<PickUpLocationTaxi> getPickUpLocationTaxis() {
        return this.pickUpLocationTaxis;
    }

    public void setPickUpLocationTaxis(Set<PickUpLocationTaxi> pickUpLocationTaxis) {
        this.pickUpLocationTaxis = pickUpLocationTaxis;
    }

    @ManyToMany(mappedBy = "taxis", fetch = FetchType.LAZY)
    public Set<PickUpLocation> getPickUpLocations() {
        return pickUpLocations;
    }

    public void setPickUpLocations(Set<PickUpLocation> pickUpLocations) {
        this.pickUpLocations = pickUpLocations;
    }

}
