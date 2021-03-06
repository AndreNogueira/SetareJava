package model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="city"
    ,catalog="Setare"
)
public class City  implements java.io.Serializable {


     private Integer id;
     private Country country;
     private String name;
     private boolean isTaxi;
     private int numberCar;
     private Set<Subsidiary> subsidiaries = new HashSet<>(0);
     private Set<PickUpLocation> pickUpLocations = new HashSet<>(0);

    public City() {
    }

	
    public City(Country country, String name, boolean isTaxi, int numberCar) {
        this.country = country;
        this.name = name;
        this.isTaxi = isTaxi;
        this.numberCar = numberCar;
    }
    public City(Country country, String name, boolean isTaxi, int numberCar, Set<Subsidiary> subsidiaries, Set<PickUpLocation> pickUpLocations) {
       this.country = country;
       this.name = name;
       this.isTaxi = isTaxi;
       this.numberCar = numberCar;
       this.subsidiaries = subsidiaries;
       this.pickUpLocations = pickUpLocations;
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
    @JoinColumn(name="country_id", nullable=false)
    public Country getCountry() {
        return this.country;
    }
    
    public void setCountry(Country country) {
        this.country = country;
    }

    
    @Column(name="name", nullable=false)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="is_taxi", nullable=false)
    public boolean isIsTaxi() {
        return this.isTaxi;
    }
    
    public void setIsTaxi(boolean isTaxi) {
        this.isTaxi = isTaxi;
    }

    
    @Column(name="number_car", nullable=false)
    public int getNumberCar() {
        return this.numberCar;
    }
    
    public void setNumberCar(int numberCar) {
        this.numberCar = numberCar;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="city")
    public Set<Subsidiary> getSubsidiaries() {
        return this.subsidiaries;
    }
    
    public void setSubsidiaries(Set<Subsidiary> subsidiaries) {
        this.subsidiaries = subsidiaries;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="city")
    public Set<PickUpLocation> getPickUpLocations() {
        return this.pickUpLocations;
    }
    
    public void setPickUpLocations(Set<PickUpLocation> pickUpLocations) {
        this.pickUpLocations = pickUpLocations;
    }




}


