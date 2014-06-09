package model;

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
@Table(name = "drop_off_location", catalog = "Setare"
)
public class DropOffLocation implements java.io.Serializable {

    private Integer id;
    private String name;
    private Set<DropOffLocationPickUpLocation> dropOffLocationPickUpLocations = new HashSet<>(0);
    private Set<PickUpLocation> pickUpLocations = new HashSet<>(0);

    public DropOffLocation() {
    }

    public DropOffLocation(String name) {
        this.name = name;
    }

    public DropOffLocation(String name, Set<DropOffLocationPickUpLocation> dropOffLocationPickUpLocations) {
        this.name = name;
        this.dropOffLocationPickUpLocations = dropOffLocationPickUpLocations;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dropOffLocation")
    public Set<DropOffLocationPickUpLocation> getDropOffLocationPickUpLocations() {
        return this.dropOffLocationPickUpLocations;
    }

    public void setDropOffLocationPickUpLocations(Set<DropOffLocationPickUpLocation> dropOffLocationPickUpLocations) {
        this.dropOffLocationPickUpLocations = dropOffLocationPickUpLocations;
    }

    @ManyToMany(mappedBy = "dropOffLocations", fetch = FetchType.LAZY)
    public Set<PickUpLocation> getPickUpLocations() {
        return pickUpLocations;
    }

    public void setPickUpLocations(Set<PickUpLocation> pickUpLocations) {
        this.pickUpLocations = pickUpLocations;
    }

}
