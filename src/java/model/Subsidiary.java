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
@Table(name="subsidiary"
    ,catalog="Setare"
)
public class Subsidiary  implements java.io.Serializable {


     private Integer id;
     private Agency agency;
     private City city;
     private String name;
     private String address;
     private Set<CarService> carServicesForDropOffSubsidiaryId = new HashSet<>(0);
     private Set<CarService> carServicesForPickUpSubsidiaryId = new HashSet<>(0);

    public Subsidiary() {
    }

	
    public Subsidiary(Agency agency, City city, String name, String address) {
        this.agency = agency;
        this.city = city;
        this.name = name;
        this.address = address;
    }
    public Subsidiary(Agency agency, City city, String name, String address, Set<CarService> carServicesForDropOffSubsidiaryId, Set<CarService> carServicesForPickUpSubsidiaryId) {
       this.agency = agency;
       this.city = city;
       this.name = name;
       this.address = address;
       this.carServicesForDropOffSubsidiaryId = carServicesForDropOffSubsidiaryId;
       this.carServicesForPickUpSubsidiaryId = carServicesForPickUpSubsidiaryId;
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
    @JoinColumn(name="agency_id", nullable=false)
    public Agency getAgency() {
        return this.agency;
    }
    
    public void setAgency(Agency agency) {
        this.agency = agency;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="city_id", nullable=false)
    public City getCity() {
        return this.city;
    }
    
    public void setCity(City city) {
        this.city = city;
    }

    
    @Column(name="name", nullable=false)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="address", nullable=false)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="subsidiaryByDropOffSubsidiaryId")
    public Set<CarService> getCarServicesForDropOffSubsidiaryId() {
        return this.carServicesForDropOffSubsidiaryId;
    }
    
    public void setCarServicesForDropOffSubsidiaryId(Set<CarService> carServicesForDropOffSubsidiaryId) {
        this.carServicesForDropOffSubsidiaryId = carServicesForDropOffSubsidiaryId;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="subsidiaryByPickUpSubsidiaryId")
    public Set<CarService> getCarServicesForPickUpSubsidiaryId() {
        return this.carServicesForPickUpSubsidiaryId;
    }
    
    public void setCarServicesForPickUpSubsidiaryId(Set<CarService> carServicesForPickUpSubsidiaryId) {
        this.carServicesForPickUpSubsidiaryId = carServicesForPickUpSubsidiaryId;
    }




}


