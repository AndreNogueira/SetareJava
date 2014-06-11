package model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pick_up_location", catalog = "Setare"
)
public class PickUpLocation implements java.io.Serializable {

    private Integer id;
    private City city;
    private String name;
    private Set<DropOffLocationPickUpLocation> dropOffLocationPickUpLocations = new HashSet<>(0);
    private Set<PickUpLocationTaxi> pickUpLocationTaxis = new HashSet<>(0);
    
    
    private Set<DropOffLocation> dropOffLocations = new HashSet<>(0);
    private Set<Taxi> taxis = new HashSet<>(0);

    public PickUpLocation() {
    }

    public PickUpLocation(City city, String name) {
        this.city = city;
        this.name = name;
    }

    public PickUpLocation(City city, String name, Set<DropOffLocationPickUpLocation> dropOffLocationPickUpLocations, Set<PickUpLocationTaxi> pickUpLocationTaxis) {
        this.city = city;
        this.name = name;
        this.dropOffLocationPickUpLocations = dropOffLocationPickUpLocations;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    public City getCity() {
        return this.city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pickUpLocation")
    public Set<DropOffLocationPickUpLocation> getDropOffLocationPickUpLocations() {
        return this.dropOffLocationPickUpLocations;
    }

    public void setDropOffLocationPickUpLocations(Set<DropOffLocationPickUpLocation> dropOffLocationPickUpLocations) {
        this.dropOffLocationPickUpLocations = dropOffLocationPickUpLocations;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pickUpLocation")
    public Set<PickUpLocationTaxi> getPickUpLocationTaxis() {
        return this.pickUpLocationTaxis;
    }

    public void setPickUpLocationTaxis(Set<PickUpLocationTaxi> pickUpLocationTaxis) {
        this.pickUpLocationTaxis = pickUpLocationTaxis;
    }

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "drop_off_location_pick_up_location", catalog = "Setare",
            joinColumns = {@JoinColumn(name = "pick_up_location_id")},
            inverseJoinColumns = {@JoinColumn(name="drop_off_location_id")}
            )
    public Set<DropOffLocation> getDropOffLocations() {
        return dropOffLocations;
    }

    public void setDropOffLocations(Set<DropOffLocation> dropOffLocations) {
        this.dropOffLocations = dropOffLocations;
    }

    @ManyToMany(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="pick_up_location_taxi",catalog = "Setare",
               joinColumns = {@JoinColumn(name = "pick_up_location_id")},
               inverseJoinColumns = {@JoinColumn(name = "taxi_id")}
            )
    public Set<Taxi> getTaxis() {
        return taxis;
    }

    public void setTaxis(Set<Taxi> taxis) {
        this.taxis = taxis;
    }
    
    
    
    

}
