package model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "drop_off_location_pick_up_location", catalog = "Setare"
)
public class DropOffLocationPickUpLocation implements java.io.Serializable {

    private DropOffLocationPickUpLocationId id;
    private PickUpLocation pickUpLocation;
    private DropOffLocation dropOffLocation;

    public DropOffLocationPickUpLocation() {
    }

    public DropOffLocationPickUpLocation(DropOffLocationPickUpLocationId id, PickUpLocation pickUpLocation, DropOffLocation dropOffLocation) {
        this.id = id;
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
    }

    @EmbeddedId

    @AttributeOverrides({
        @AttributeOverride(name = "dropOffLocationId", column = @Column(name = "drop_off_location_id", nullable = false)),
        @AttributeOverride(name = "pickUpLocationId", column = @Column(name = "pick_up_location_id", nullable = false))})
    public DropOffLocationPickUpLocationId getId() {
        return this.id;
    }

    public void setId(DropOffLocationPickUpLocationId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pick_up_location_id", nullable = false, insertable = false, updatable = false)
    public PickUpLocation getPickUpLocation() {
        return this.pickUpLocation;
    }

    public void setPickUpLocation(PickUpLocation pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drop_off_location_id", nullable = false, insertable = false, updatable = false)
    public DropOffLocation getDropOffLocation() {
        return this.dropOffLocation;
    }

    public void setDropOffLocation(DropOffLocation dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

}
